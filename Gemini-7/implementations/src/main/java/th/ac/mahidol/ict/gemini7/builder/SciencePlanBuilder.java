package th.ac.mahidol.ict.gemini7.builder;

import edu.gemini.app.ocs.model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SciencePlanBuilder {
    private String creator;
    private String submitter;
    private double funding;
    private String objectives;
    private StarSystem.CONSTELLATIONS starSystem;
    private Date startDate;
    private Date endDate;
    private SciencePlan.TELESCOPELOC telescopeLocation;
    private DataProcRequirement dataProcRequirement;

    public SciencePlanBuilder withCreator(String creator) {
        this.creator = creator;
        return this;
    }

    public SciencePlanBuilder withSubmitter(String submitter) {
        this.submitter = submitter;
        return this;
    }

    public SciencePlanBuilder withFunding(double funding) {
        this.funding = funding;
        return this;
    }

    public SciencePlanBuilder withObjectives(String objectives) {
        this.objectives = objectives;
        return this;
    }

    public SciencePlanBuilder withStarSystem(StarSystem.CONSTELLATIONS system) {
        this.starSystem = system;
        return this;
    }

    public SciencePlanBuilder withStartDate(String dateStr) {
        try {
            this.startDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace(); //
        }
        return this;
    }

    public SciencePlanBuilder withEndDate(String dateStr) {
        try {
            this.endDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return this;
    }


    public SciencePlanBuilder withTelescopeLocation(SciencePlan.TELESCOPELOC location) {
        this.telescopeLocation = location;
        return this;
    }

    public SciencePlanBuilder withRequirement(DataProcRequirement req) {
        this.dataProcRequirement = req;
        return this;
    }

    public SciencePlan build() {
        return new SciencePlan(creator, submitter, funding, objectives, starSystem, startDate, endDate, telescopeLocation, dataProcRequirement);
    }
}