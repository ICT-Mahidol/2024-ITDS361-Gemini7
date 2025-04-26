package th.ac.mahidol.ict.gemini7.model.User;

import th.ac.mahidol.ict.gemini7.model.SciencePlan;
public class Astronomer {
    private String username;

    public SciencePlan createSciencePlan() {
        return new SciencePlan();
    }

    public boolean saveSciencePlan() {
        return true; // Mock
    }

    public void submitPlan() {}
    public void retrieveSciencePlans() {}
    public void testSciencePlan() {}
    public void selectPlan() {}
    public void finish() {}
    public void updateTestPlan() {}
    public void loadSimulationEnvironment() {}
    public void startSystemSelectionTest() {}
    public void imageProcessingConfigurationTest() {}
    public void telescopeLocationTest() {}
    public void observationDurationTest() {}
    public void updatePlanStatus() {}
}