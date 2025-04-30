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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
@RequestMapping("/science-plan")
public class SciencePlanController {

    @Autowired
    private SciencePlanFacade facade;

    @GetMapping("/create")
    public String showCreateForm(HttpSession session, Model model)  {
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
        }catch (IllegalArgumentException ex) {
            model.addAttribute("errorMessage", ex.getMessage());
            model.addAttribute("success", false);
        } catch (Exception ex) {
            model.addAttribute("errorMessage", "Input data is not compatible with the legacy OCS system.");
            model.addAttribute("success", false);
        }
        return "create-science-plan";
    }

    @GetMapping("/test")
    public String showTestForm(Model model)  {
        List<SciencePlan> plans = facade.getAllSciencePlans();
        if (plans.isEmpty()) {
            model.addAttribute("noPlans", true);
        } else {
            model.addAttribute("plans", plans);
        }
        return "test-science-plan";
    }

    @PostMapping("/test/{id}")
    public String testSciencePlan(@PathVariable("id") Long planId, Model model) {
        // อัปเดตสถานะเป็น "TESTED" ที่ backend
        SciencePlan plan = facade.getSciencePlanById(planId);
        plan.setStatus("TESTED");
        facade.saveSciencePlan(plan); // บันทึกสถานะใหม่
        System.out.println("Science Plan Status " + plan.getStatus());

        // ส่งข้อมูลที่จำเป็นกลับไปยัง frontend
//        model.addAttribute("testedPlanId", planId);

        return "redirect:/science-plan/test";
//        return "test-science-plan";
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
    public String submitPlan(@PathVariable Long planId, RedirectAttributes redirectAttributes) {
        SciencePlan plan = facade.getSciencePlanById(planId);

        if ("CREATED".equals(plan.getStatus())) {
            redirectAttributes.addFlashAttribute("error", "You must test the Science Plan before submission.");
            return "redirect:/science-plan/test";
        }

        if ("TESTED".equals(plan.getStatus())) {
            plan.setStatus("SUBMITTED");
            facade.saveSciencePlan(plan);
            redirectAttributes.addFlashAttribute("success", "Plan SUBMITTED successfully!");
        } else {
            redirectAttributes.addFlashAttribute("error", "Only TESTED plans can be SUBMITTED.");
        }

        return "redirect:/science-plan/submit";
    }

}
