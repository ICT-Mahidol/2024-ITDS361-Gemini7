package th.ac.mahidol.ict.gemini7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import th.ac.mahidol.ict.gemini7.model.SciencePlan;

public interface OCSRepository extends JpaRepository<SciencePlan, Long> {
    // สามารถไม่ต้องเขียน save() เพราะ JpaRepository มีให้อยู่แล้ว
}
