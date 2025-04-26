package th.ac.mahidol.ict.gemini7.facade;

import edu.gemini.app.ocs.model.SciencePlan;
import org.springframework.stereotype.Service;
import th.ac.mahidol.ict.gemini7.builder.SciencePlanBuilder;

@Service
public class SciencePlanFacade {

    public boolean createSciencePlan(SciencePlan planInput) {
        try {
            SciencePlan plan = new SciencePlanBuilder()
                    .withCreator(planInput.getCreator())
                    .withSubmitter(planInput.getSubmitter())
                    .withFunding(planInput.getFundingInUSD())
                    .withObjectives(planInput.getObjectives())
                    .withStartDate(planInput.getStartDate())
                    .withEndDate(planInput.getEndDate())
                    .withStarSystem(planInput.getStarSystem())
                    .withTelescopeLocation(planInput.getTelescopeLocation())
                    .withRequirement(planInput.getDataProcRequirements().get(0))
                    .build();
            // Stub for saving logic (e.g., via API or DB)
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}