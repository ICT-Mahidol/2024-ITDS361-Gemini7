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

    public String fileType;
    public String fileQuality;
    public String colorType;
    public double contrast;
    public double brightness;
    public double saturation;
    public double exposure;
    public double shadows;
    public double highlights;
    public double whites;
    public double blacks;
    public double luminance;
    public double hue;

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
