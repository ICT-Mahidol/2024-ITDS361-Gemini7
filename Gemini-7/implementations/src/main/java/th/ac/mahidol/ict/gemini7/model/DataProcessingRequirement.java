package th.ac.mahidol.ict.gemini7.model;

import jakarta.persistence.*;

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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "science_plan_id")
    private SciencePlan sciencePlan;  // เชื่อมโยงกับ SciencePlan

    // --- Getters and Setters ---
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getFileType() { return fileType; }
    public void setFileType(String fileType) { this.fileType = fileType; }

    public String getFileQuality() { return fileQuality; }
    public void setFileQuality(String fileQuality) { this.fileQuality = fileQuality; }

    public String getColorType() { return colorType; }
    public void setColorType(String colorType) { this.colorType = colorType; }

    public double getContrast() { return contrast; }
    public void setContrast(double contrast) { this.contrast = contrast; }

    public double getBrightness() { return brightness; }
    public void setBrightness(double brightness) { this.brightness = brightness; }

    public double getSaturation() { return saturation; }
    public void setSaturation(double saturation) { this.saturation = saturation; }

    public double getExposure() { return exposure; }
    public void setExposure(double exposure) { this.exposure = exposure; }

    public double getShadows() { return shadows; }
    public void setShadows(double shadows) { this.shadows = shadows; }

    public double getHighlights() { return highlights; }
    public void setHighlights(double highlights) { this.highlights = highlights; }

    public double getWhites() { return whites; }
    public void setWhites(double whites) { this.whites = whites; }

    public double getBlacks() { return blacks; }
    public void setBlacks(double blacks) { this.blacks = blacks; }

    public double getLuminance() { return luminance; }
    public void setLuminance(double luminance) { this.luminance = luminance; }

    public double getHue() { return hue; }
    public void setHue(double hue) { this.hue = hue; }

    public SciencePlan getSciencePlan() {
        return sciencePlan;
    }

    public void setSciencePlan(SciencePlan sciencePlan) {
        this.sciencePlan = sciencePlan;
    }

    public void configureProcessing() {
        // Mock configuration
    }

    public boolean validateProcessing() {
        return fileType != null && fileQuality != null;
    }
}
