package th.ac.mahidol.ict.gemini7.builder;

import edu.gemini.app.ocs.model.DataProcRequirement;
import th.ac.mahidol.ict.gemini7.model.DataProcessingRequirement;
import th.ac.mahidol.ict.gemini7.model.SciencePlan;

import java.time.LocalDate;

public class SciencePlanBuilder {

    private String planID;
    private String planName;
    private String creator;
    private double funding;
    private String objective;
    private LocalDate startDate;
    private LocalDate endDate;
    private String target;
    private String status;
    private String submitter;
    private String starSystem;
    private String telescopeLocation;
    private DataProcessingRequirement dataProcessingRequirement;

    public SciencePlanBuilder withPlanID(String planID) {
        this.planID = planID;
        return this;
    }

    public SciencePlanBuilder withPlanName(String planName) {
        this.planName = planName;
        return this;
    }

    public SciencePlanBuilder withCreator(String creator) {
        this.creator = creator;
        return this;
    }

    public SciencePlanBuilder withFunding(double funding) {
        this.funding = funding;
        return this;
    }

    public SciencePlanBuilder withObjective(String objective) {
        this.objective = objective;
        return this;
    }

    public SciencePlanBuilder withStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public SciencePlanBuilder withEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public SciencePlanBuilder withTarget(String target) {
        this.target = target;
        return this;
    }

    public SciencePlanBuilder withStatus(String status) {
        this.status = status;
        return this;
    }

    public SciencePlanBuilder withSubmitter(String submitter) {
        this.submitter = submitter;
        return this;
    }

    public SciencePlanBuilder withStarSystem(String starSystem) {
        this.starSystem = starSystem;
        return this;
    }

    public SciencePlanBuilder withTelescopeLocation(String telescopeLocation) {
        this.telescopeLocation = telescopeLocation;
        return this;
    }

    public SciencePlanBuilder withDataProcessingRequirement(DataProcessingRequirement dataProcessingRequirement) {
        this.dataProcessingRequirement = dataProcessingRequirement;
        return this;
    }

    public SciencePlan build() {
        SciencePlan sciencePlan = new SciencePlan();
        sciencePlan.setPlanID(this.planID);
        sciencePlan.setPlanName(this.planName);
        sciencePlan.setCreator(this.creator);
        sciencePlan.setFunding(this.funding);
        sciencePlan.setObjective(this.objective);
        sciencePlan.setStartDate(this.startDate);
        sciencePlan.setEndDate(this.endDate);
        sciencePlan.setTarget(this.target);
        sciencePlan.setStatus(this.status);
        sciencePlan.setSubmitter(this.submitter);
        sciencePlan.setStarSystem(this.starSystem);
        sciencePlan.setTelescopeLocation(this.telescopeLocation);
        sciencePlan.setDataProcessingRequirement(this.dataProcessingRequirement);
        return sciencePlan;
    }

}
