package th.ac.mahidol.ict.gemini7.service;

import edu.gemini.app.ocs.model.DataProcRequirement;
import edu.gemini.app.ocs.model.StarSystem;
import edu.gemini.app.ocs.model.SciencePlan.TELESCOPELOC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.ac.mahidol.ict.gemini7.model.SciencePlan;
import th.ac.mahidol.ict.gemini7.model.DataProcessingRequirement;
import th.ac.mahidol.ict.gemini7.repository.OCSRepository;
import th.ac.mahidol.ict.gemini7.repository.SciencePlanRepository;
import th.ac.mahidol.ict.gemini7.mapper.SciencePlanMapper;

import java.sql.Date;
import java.time.LocalDate;

@Service
public class SciencePlanService {

    @Autowired
    private OCSRepository ocsRepository;

    @Autowired
    private SciencePlanRepository sciencePlanRepository;

    public String createSciencePlan(SciencePlan localPlan) {
        try {
            // แปลง LocalDate เป็น java.sql.Date
            Date startDate = Date.valueOf(localPlan.getStartDate()); // แปลง LocalDate เป็น Date
            Date endDate = Date.valueOf(localPlan.getEndDate()); // แปลง LocalDate เป็น Date

            // แปลงข้อมูล DataProcessingRequirement จาก local ไปยัง OCS
            DataProcessingRequirement dpr = localPlan.getDataProcessingRequirement();
            DataProcRequirement ocsDpr = new DataProcRequirement(
                    dpr.getFileType(),
                    dpr.getFileQuality(),
                    dpr.getColorType(),
                    dpr.getContrast(),
                    dpr.getBrightness(),
                    dpr.getSaturation(),
                    dpr.getExposure(),
                    dpr.getShadows(),
                    dpr.getHighlights(),
                    dpr.getWhites(),
                    dpr.getBlacks(),
                    dpr.getLuminance(),
                    dpr.getHue()
            );

            // สร้าง SciencePlan ของ OCS
            edu.gemini.app.ocs.model.SciencePlan ocsPlan = new edu.gemini.app.ocs.model.SciencePlan(
                    localPlan.getCreator(),
                    localPlan.getSubmitter(),
                    localPlan.getFunding(),
                    localPlan.getObjective(),
                    StarSystem.CONSTELLATIONS.valueOf(localPlan.getStarSystem()),
                    startDate, // startDate เป็น java.sql.Date
                    endDate, // endDate เป็น java.sql.Date
                    TELESCOPELOC.valueOf(localPlan.getTelescopeLocation()),
                    ocsDpr
            );

            // บันทึกลง OCS
            String result = ocsRepository.saveSciencePlan(ocsPlan);
            System.out.println("Saved to OCS: " + result);
            return result;
        } catch (Exception e) {
            return "Error creating science plan: " + e.getMessage();
        }
    }
}
