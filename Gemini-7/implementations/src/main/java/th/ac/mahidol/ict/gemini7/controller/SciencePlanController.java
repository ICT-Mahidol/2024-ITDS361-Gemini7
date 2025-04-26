package th.ac.mahidol.ict.gemini7.controller;

import edu.gemini.app.ocs.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import th.ac.mahidol.ict.gemini7.facade.SciencePlanFacade;

@Controller
@RequestMapping("/science-plan")
public class SciencePlanController {

    @Autowired
    private SciencePlanFacade facade;

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("sciencePlan", new SciencePlan());
        return "create-science-plan";
    }

    @PostMapping("/create")
    public String createSciencePlan(@ModelAttribute SciencePlan plan, Model model) {
        boolean success = facade.createSciencePlan(plan);
        model.addAttribute("success", success);
        return "create-science-plan";
    }
}
