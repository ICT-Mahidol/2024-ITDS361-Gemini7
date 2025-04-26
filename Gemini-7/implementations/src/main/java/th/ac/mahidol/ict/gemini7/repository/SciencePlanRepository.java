package th.ac.mahidol.ict.gemini7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th.ac.mahidol.ict.gemini7.model.SciencePlan;

@Repository
public interface SciencePlanRepository extends JpaRepository<th.ac.mahidol.ict.gemini7.model.SciencePlan, Long> {
}
