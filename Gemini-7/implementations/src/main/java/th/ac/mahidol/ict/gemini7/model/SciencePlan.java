package th.ac.mahidol.ict.gemini7.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "create_science_plan")
@Setter
@Getter

public class SciencePlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID ในฐานข้อมูล

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

    private String fileQuality;
    private double contrast;
    private double brightness;
    private double saturation;



    @OneToOne(cascade = CascadeType.ALL)
    private DataProcessingRequirement dataProcRequirement;



    public boolean submitPlan() {
        this.status = "SUBMITTED";
        return true;
    }

    public void updateStatus() {
        if ("TESTED".equals(this.status)) {
            this.status = "READY";
        }
    }

    public boolean validateProcessing() {
        return true;
    }

    public boolean validateStandardEnable() {
        return true;
    }

    public boolean validateOCSCompatibility() {
        return true;
    }

}