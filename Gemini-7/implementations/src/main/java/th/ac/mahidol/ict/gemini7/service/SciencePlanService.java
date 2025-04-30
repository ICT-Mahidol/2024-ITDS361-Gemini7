package th.ac.mahidol.ict.gemini7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.ac.mahidol.ict.gemini7.dto.DataProcessingRequirementDTO;
import th.ac.mahidol.ict.gemini7.dto.SciencePlanDTO;
import th.ac.mahidol.ict.gemini7.model.DataProcessingRequirement;
import th.ac.mahidol.ict.gemini7.model.SciencePlan;
import th.ac.mahidol.ict.gemini7.repository.OCSRepository;
import th.ac.mahidol.ict.gemini7.repository.SciencePlanRepository;
import th.ac.mahidol.ict.gemini7.mapper.SciencePlanMapper;
import th.ac.mahidol.ict.gemini7.builder.SciencePlanBuilder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SciencePlanService {

    @Autowired
    private SciencePlanRepository sciencePlanRepository;

    // Create Science Plan
    public boolean createSciencePlan(SciencePlanDTO planDTO, String creator) {
        long planCount = sciencePlanRepository.count();
        // สร้าง planID ใหม่แบบเรียงตามจำนวนที่มีอยู่
        String planID = String.valueOf(planCount + 1);

        // สร้าง SciencePlan จาก DTO
        SciencePlan sciencePlan = new SciencePlanBuilder()
                .withPlanID(planID)
                .withPlanName(planDTO.getPlanName())
                .withCreator(creator)
                .withFunding(planDTO.getFunding())
                .withObjective(planDTO.getObjective())
                .withStartDate(planDTO.getStartDate())
                .withEndDate(planDTO.getEndDate())
                .withTarget(planDTO.getTarget())
                .withStatus("CREATED")
                .withSubmitter(planDTO.getSubmitter())
                .withStarSystem(planDTO.getStarSystem())
                .withTelescopeLocation(planDTO.getTelescopeLocation())
                .withDataProcessingRequirement(convertToDataProcRequirement(planDTO.getDataProcRequirement()))
                .build();

        // save ลง database
        sciencePlanRepository.save(sciencePlan);
        System.out.println("Save Science Plan : "+ sciencePlan);
        return true;
    }

    private DataProcessingRequirement convertToDataProcRequirement(DataProcessingRequirementDTO dto) {
        if (dto.getContrast() == null) dto.setContrast(0.0);
        if (dto.getExposure() == null) dto.setExposure(0.0);
        if (dto.getBrightness() == null) dto.setBrightness(0.0);
        if (dto.getSaturation() == null) dto.setSaturation(0.0);
        if (dto.getLuminance() == null) dto.setLuminance(0.0);
        if (dto.getHue() == null) dto.setHue(0.0);
        if (dto.getHighlights() == null) dto.setHighlights(0.0);
        if (dto.getShadows() == null) dto.setShadows(0.0);
        if (dto.getWhites() == null) dto.setWhites(0.0);
        if (dto.getBlacks() == null) dto.setBlacks(0.0);


        DataProcessingRequirement dataProcessingRequirement = new DataProcessingRequirement();
        dataProcessingRequirement.setFileType(dto.getFileType());
        dataProcessingRequirement.setFileQuality(dto.getFileQuality());
        dataProcessingRequirement.setColorType(dto.getColorType());
        dataProcessingRequirement.setContrast(dto.getContrast());
        dataProcessingRequirement.setExposure(dto.getExposure());
        dataProcessingRequirement.setBrightness(dto.getBrightness());
        dataProcessingRequirement.setSaturation(dto.getSaturation());
        dataProcessingRequirement.setLuminance(dto.getLuminance());
        dataProcessingRequirement.setHue(dto.getHue());
        dataProcessingRequirement.setHighlights(dto.getHighlights());
        dataProcessingRequirement.setShadows(dto.getShadows());
        dataProcessingRequirement.setWhites(dto.getWhites());
        dataProcessingRequirement.setBlacks(dto.getBlacks());

        System.out.println("Data Processing Requirement : "+ dataProcessingRequirement);
        return dataProcessingRequirement;
    }

    // Test Science Plan
    public List<SciencePlan> getAllSciencePlans() {
        return sciencePlanRepository.findAll();
    }

    public SciencePlan getSciencePlanById(long id) {
        return sciencePlanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SciencePlan not found with ID: " + id));
    }

    // Submit Science Plan
//    public List<SciencePlan> getSciencePlansByStatus(String status) {
//        return sciencePlanRepository.findByStatus(status);
//    }
//
//    public void saveSciencePlan(SciencePlan plan) {
//        sciencePlanRepository.save(plan);
//    }

}

