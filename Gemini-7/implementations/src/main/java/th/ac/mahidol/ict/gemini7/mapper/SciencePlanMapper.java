package th.ac.mahidol.ict.gemini7.mapper;

import edu.gemini.app.ocs.model.SciencePlan;
import edu.gemini.app.ocs.model.StarSystem;

public class SciencePlanMapper {

    public static SciencePlan toOCS(th.ac.mahidol.ict.gemini7.model.SciencePlan localPlan) {
        SciencePlan ocsPlan = new SciencePlan();
        ocsPlan.setCreator(localPlan.getCreator());
        ocsPlan.setSubmitter(localPlan.getSubmitter());
        ocsPlan.setFundingInUSD(localPlan.getFunding());
        ocsPlan.setObjectives(localPlan.getObjective());
        ocsPlan.setStarSystem(StarSystem.CONSTELLATIONS.valueOf(localPlan.getStarSystem()));
        ocsPlan.setStartDate(localPlan.getStartDate().toString() + " 00:00:00");
        ocsPlan.setEndDate(localPlan.getEndDate().toString() + " 00:00:00");
        ocsPlan.setTelescopeLocation(SciencePlan.TELESCOPELOC.HAWAII);
        ocsPlan.setStatus(SciencePlan.STATUS.SUBMITTED);
        return ocsPlan;
    }
}
