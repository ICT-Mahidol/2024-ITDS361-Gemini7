package th.ac.mahidol.ict.gemini7.model.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import th.ac.mahidol.ict.gemini7.model.SciencePlan;

@Setter
@Getter
@Entity
public class Astronomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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