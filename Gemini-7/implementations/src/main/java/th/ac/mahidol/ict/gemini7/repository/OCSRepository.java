package th.ac.mahidol.ict.gemini7.repository;

import edu.gemini.app.ocs.model.SciencePlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OCSRepository extends JpaRepository<SciencePlan, Long> {
    String saveSciencePlan(SciencePlan ocsPlan);
    // สามารถเพิ่ม query method ตามต้องการในอนาคต เช่น findByStatus, findByCreator, etc.
}
