package th.ac.mahidol.ict.gemini7.dto;

import lombok.Data;

@Data
public class DataProcessingRequirementDTO {

    private String fileType;      // PNG, JPEG, RAW
    private String fileQuality;   // Low, Fine
    private String colorType;     // color, bw

    // Common fields (both color & bw modes)
    private Double contrast;
    private Double exposure;

    // Color mode fields
    private Double brightness;
    private Double saturation;
    private Double luminance;
    private Double hue;

    // B&W mode fields
    private Double highlights;
    private Double shadows;
    private Double whites;
    private Double blacks;
}