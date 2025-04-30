package th.ac.mahidol.ict.gemini7.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import th.ac.mahidol.ict.gemini7.dto.SciencePlanDTO;
import th.ac.mahidol.ict.gemini7.facade.SciencePlanFacade;
import th.ac.mahidol.ict.gemini7.model.SciencePlan;

import java.time.temporal.ChronoUnit;
import java.util.*;

@Controller
@RequestMapping("/science-plan")
public class SciencePlanController {

    @Autowired
    private SciencePlanFacade facade;

    // Create Science Plan
    @GetMapping("/create")
    public String showCreateForm(HttpSession session, Model model) {
        String username = (String) session.getAttribute("username"); // ดึงค่า username จาก session
        model.addAttribute("loginUser", username);  // ส่ง username ไปยัง Model
        model.addAttribute("sciencePlan", new SciencePlan());
        return "create-science-plan";
    }

    @PostMapping("/create")
    public String createSciencePlan(@ModelAttribute SciencePlanDTO planDTO, Model model, HttpSession session) {
        String username = (String) session.getAttribute("username");
        planDTO.setCreator(username);
        model.addAttribute("loginUser", username);  // ส่ง username ไปยัง Model
        System.out.println("Science Plan DTO " + planDTO);
        try {
            facade.createSciencePlan(planDTO, username);
            model.addAttribute("success", true);
            return "redirect:/home";
        } catch (IllegalArgumentException ex) {
            model.addAttribute("errorMessage", ex.getMessage());
            model.addAttribute("success", false);
        } catch (Exception ex) {
            model.addAttribute("errorMessage", "Input data is not compatible with the legacy OCS system.");
            model.addAttribute("success", false);
        }
        return "create-science-plan";
    }

    // Test Science Plan
    @GetMapping("/test")
    public String showTestForm(Model model) {
        List<SciencePlan> plans = facade.getAllSciencePlans();
        if (plans.isEmpty()) {
            model.addAttribute("noPlans", true);
        } else {
            model.addAttribute("plans", plans);
        }
        return "test-science-plan";
    }

    @PostMapping("/test/{id}")
    public String testSciencePlan(@PathVariable("id") Long planId, RedirectAttributes redirectAttributes) {
        try {
            SciencePlan plan = facade.getSciencePlanById(planId);
            if (plan == null) {
//                redirectAttributes.addFlashAttribute("errorMessage", "Your selected science plan does not exist.");
//                return "redirect:/science-plan/test";
            }

            Map<String, Boolean> testResults = performAllTests(plan);
            boolean allPassed = testResults.values().stream().allMatch(Boolean::booleanValue);

            if (allPassed) {
                plan.setStatus("TESTED");
                facade.saveSciencePlan(plan);
                redirectAttributes.addFlashAttribute("successMessage",
                        "All tests passed. Science plan status updated to TESTED.");
            } else {
                redirectAttributes.addFlashAttribute("errorMessage",
                        "Some test cases failed. Please see details below.");
            }

            redirectAttributes.addFlashAttribute("testResults", testResults);
            redirectAttributes.addFlashAttribute("testedPlanId", plan.getPlanID());
            redirectAttributes.addFlashAttribute("testedPlanName", plan.getPlanName());

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An unexpected error occurred.");
        }

        return "redirect:/science-plan/test";
    }

    // Finish การทดสอบ
    @GetMapping("/finish")
    public String finishTest(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("successMessage", "Testing process has been completed.");
        return "redirect:/home";
    }

    // รายการ test cases ทั้งหมด
    private Map<String, Boolean> performAllTests(SciencePlan plan) {
        Map<String, Boolean> results = new LinkedHashMap<>();
        results.put("Star System Selection Test", testStarSystem(plan));
        results.put("Image Processing Configuration Test", testImageProcessing(plan));
        results.put("Telescope Location Test", testTelescopeLocation(plan));
        results.put("Observation Duration Test", testObservationDuration(plan));
        return results;
    }

    private boolean testStarSystem(SciencePlan plan) {
        System.out.println("plan.getStarSystem() : " + plan.getStarSystem() );
        return plan.getStarSystem() != null && !plan.getStarSystem().trim().isEmpty();
    }

    private boolean testImageProcessing(SciencePlan plan) {
        System.out.println("plan.getImageQuality() : " + plan.getDataProcRequirement().getFileQuality() );
        System.out.println("plan.getContrast() : " + plan.getDataProcRequirement().getContrast() );
        System.out.println("plan.getBrightness() : " + plan.getDataProcRequirement().getBrightness() );
        System.out.println("plan.getSaturation() : " + plan.getDataProcRequirement().getSaturation() );

        return "Fine".equals(plan.getDataProcRequirement().getFileQuality()) &&
                plan.getDataProcRequirement().getContrast() > 0 &&
                plan.getDataProcRequirement().getBrightness() > 0 &&
                plan.getDataProcRequirement().getSaturation() > 0;
    }

    private boolean testTelescopeLocation(SciencePlan plan) {
        System.out.println("plan.getTelescopeLocation() : " + plan.getTelescopeLocation() );
        return plan.getTelescopeLocation() != null && !plan.getTelescopeLocation().trim().isEmpty();
    }

    private boolean testObservationDuration(SciencePlan plan) {
        long duration = ChronoUnit.DAYS.between(plan.getStartDate(), plan.getEndDate());
        System.out.println("Duration: " + duration + " days");
        return duration >= 10;
    }


    // Submit Science Plan
    // Display the plans with optional filtering
    @GetMapping("/submit")
    public String showSubmitForm(@RequestParam(value = "status", required = false, defaultValue = "ALL") String status, Model model) {
        List<SciencePlan> plans;
        System.out.println("Filtering by status: " + status);
        if ("ALL".equals(status)) {
            plans = facade.getAllSciencePlans();
        } else {
            plans = facade.getSciencePlansByStatus(status);
        }

        model.addAttribute("plans", plans);
        model.addAttribute("status", status); // สำคัญสำหรับ dropdown
        if (plans.isEmpty()) {
            model.addAttribute("noPlans", true);
        }

        return "submit-science-plan";
    }

    // Handle plan submission
    @PostMapping("/submit/{planId}")
    public String submitPlan(@PathVariable Long planId, RedirectAttributes redirectAttributes, HttpSession session) {
        SciencePlan plan = facade.getSciencePlanById(planId);

        if ("CREATED".equals(plan.getStatus())) {
            redirectAttributes.addFlashAttribute("errorMessage", "You must test the Science Plan before submission.");
            return "redirect:/science-plan/test";
        }

        if ("TESTED".equals(plan.getStatus())) {
            String username = (String) session.getAttribute("username");
            plan.setStatus("SUBMITTED");
            plan.setSubmitter(username);
            facade.saveSciencePlan(plan);
            redirectAttributes.addFlashAttribute("successMessage", "Plan SUBMITTED successfully!");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Only TESTED plans can be SUBMITTED.");
        }

        return "redirect:/science-plan/submit";
    }

}