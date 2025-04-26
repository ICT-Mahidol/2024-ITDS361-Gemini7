package th.ac.mahidol.ict.gemini7.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "science_plan")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class SciencePlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID ในฐานข้อมูล

    public String planID;
    public String planName;
    public String creator;
    public double funding;
    public String objective;
    public LocalDate startDate;
    public LocalDate endDate;
    public String target;
    public String status;



    private String submitter;


    private String starSystem;

    private String telescopeLocation;

    @OneToOne(mappedBy = "sciencePlan", fetch = FetchType.LAZY)
    private DataProcessingRequirement dataProcessingRequirement;

    // --- Getters and Setters ---
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getPlanID() {
        return planID;
    }
    public void setPlanID(String planID) {
        this.planID = planID;
    }

    public String getPlanName() {return planName;}
    public void setPlanName(String planName) {this.planName = planName;}

    public String getCreator() {return creator;}
    public void setCreator(String creator) {this.creator = creator;}

    public double getFunding() {return funding;}
    public void setFunding(double funding) {this.funding = funding;}

    public String getObjective() {return objective;}
    public void setObjective(String objective) {this.objective = objective;}

    public LocalDate getStartDate() {return startDate;}
    public void setStartDate(LocalDate startDate) {this.startDate = startDate;}

    public LocalDate getEndDate() {return endDate;}
    public void setEndDate(LocalDate endDate) {this.endDate = endDate;}

    public String getTarget() {return target;}
    public void setTarget(String target) {this.target = target;}

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public DataProcessingRequirement getDataProcessingRequirement() {
        return dataProcessingRequirement;
    }
    public void setDataProcessingRequirement(DataProcessingRequirement dataProcessingRequirement) {
        this.dataProcessingRequirement = dataProcessingRequirement;
    }

}