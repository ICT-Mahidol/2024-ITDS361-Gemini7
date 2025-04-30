package th.ac.mahidol.ict.gemini7.mapper;

import edu.gemini.app.ocs.model.*;
import th.ac.mahidol.ict.gemini7.dto.SciencePlanDTO;
import th.ac.mahidol.ict.gemini7.model.SciencePlan;

public class SciencePlanMapper {

    public static edu.gemini.app.ocs.model.SciencePlan toOCS(SciencePlanDTO planDTO) {
        // แปลง DataProcessingRequirementDTO ไปเป็น DataProcRequirement
        edu.gemini.app.ocs.model.DataProcRequirement ocsDpr = new edu.gemini.app.ocs.model.DataProcRequirement(
                planDTO.getDataProcRequirement().getFileType(),
                planDTO.getDataProcRequirement().getFileQuality(),
                planDTO.getDataProcRequirement().getColorType(),
                planDTO.getDataProcRequirement().getContrast(),
                planDTO.getDataProcRequirement().getExposure(),
                planDTO.getDataProcRequirement().getBrightness(),
                planDTO.getDataProcRequirement().getSaturation(),
                planDTO.getDataProcRequirement().getLuminance(),
                planDTO.getDataProcRequirement().getHue(),
                planDTO.getDataProcRequirement().getHighlights(),
                planDTO.getDataProcRequirement().getShadows(),
                planDTO.getDataProcRequirement().getWhites(),
                planDTO.getDataProcRequirement().getBlacks()
        );

        // สร้าง SciencePlan จากข้อมูลที่ได้รับ
        return new edu.gemini.app.ocs.model.SciencePlan(
                planDTO.getPlanName(),
                planDTO.getCreator(),
                planDTO.getFunding(),
                planDTO.getObjective(),
                edu.gemini.app.ocs.model.StarSystem.CONSTELLATIONS.valueOf(planDTO.getStarSystem()),
                java.sql.Date.valueOf(planDTO.getStartDate()),
                java.sql.Date.valueOf(planDTO.getEndDate()),
                edu.gemini.app.ocs.model.SciencePlan.TELESCOPELOC.valueOf(planDTO.getTelescopeLocation()),
                ocsDpr
        );
    }
}
