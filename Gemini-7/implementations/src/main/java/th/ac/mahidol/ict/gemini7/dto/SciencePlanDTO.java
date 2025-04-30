package th.ac.mahidol.ict.gemini7.dto;

import lombok.Data;
import java.time.LocalDate;
import jakarta.persistence.*;

@Data
public class SciencePlanDTO {

    // ------------- Science Plan Information -------------
    private String planName;
    private String creator;
    private double funding;
    private String objective;
    private LocalDate startDate;
    private LocalDate endDate;
    private String target;
    private String submitter;
    private String starSystem;
    private String telescopeLocation;

    // ------------- Data Processing Requirements -------------
    private DataProcessingRequirementDTO dataProcRequirement;
}
