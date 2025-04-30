package th.ac.mahidol.ict.gemini7.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class DataProcessingRequirement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileType;
    private String fileQuality;
    private String colorType;
    private double contrast;
    private double brightness;
    private double saturation;
    private double exposure;
    private double shadows;
    private double highlights;
    private double whites;
    private double blacks;
    private double luminance;
    private double hue;

    @OneToOne
    @JoinColumn(name = "science_plan_id")
    private SciencePlan sciencePlan;  // เชื่อมโยงกับ SciencePlan

    public void configureProcessing() {
        // Mock configuration
    }

    public boolean validateProcessing() {
        return fileType != null && fileQuality != null;
    }
}
