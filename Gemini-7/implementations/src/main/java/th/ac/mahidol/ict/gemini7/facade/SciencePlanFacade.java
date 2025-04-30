package th.ac.mahidol.ict.gemini7.facade;

import edu.gemini.app.ocs.model.DataProcRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import th.ac.mahidol.ict.gemini7.builder.SciencePlanBuilder;
import th.ac.mahidol.ict.gemini7.dto.DataProcessingRequirementDTO;
import th.ac.mahidol.ict.gemini7.dto.SciencePlanDTO;
import th.ac.mahidol.ict.gemini7.model.DataProcessingRequirement;
import th.ac.mahidol.ict.gemini7.repository.SciencePlanRepository;
import th.ac.mahidol.ict.gemini7.service.SciencePlanService;
import th.ac.mahidol.ict.gemini7.model.SciencePlan;

import java.util.List;
import java.util.UUID;

@Component
public class SciencePlanFacade {

    @Autowired
    private SciencePlanService sciencePlanService;

    @Autowired
    private SciencePlanRepository sciencePlanRepository;

    // Create Science Plan
    public boolean createSciencePlan(SciencePlanDTO planDTO, String creator) {
        try {
            // ส่ง DTO และ creator ไปที่ service ตรง ๆ
            return sciencePlanService.createSciencePlan(planDTO, creator);
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while creating the Science Plan: " + e.getMessage());
        }
    }
    // Test Science Plan
    public void saveSciencePlan(SciencePlan plan) {
        sciencePlanRepository.save(plan);
    }
    public List<SciencePlan> getAllSciencePlans() {
        return sciencePlanService.getAllSciencePlans();
    }

    public SciencePlan getSciencePlanById(long id) {
        return sciencePlanService.getSciencePlanById(id);
    }

    // Submit Science Plan
    public List<SciencePlan> getSciencePlansByStatus(String status) {
        return sciencePlanRepository.findByStatus(status);
    }

}

