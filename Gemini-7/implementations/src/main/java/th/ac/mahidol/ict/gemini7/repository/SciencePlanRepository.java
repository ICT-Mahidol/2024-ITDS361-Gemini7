package th.ac.mahidol.ict.gemini7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th.ac.mahidol.ict.gemini7.model.SciencePlan;
import th.ac.mahidol.ict.gemini7.model.User.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface SciencePlanRepository extends JpaRepository<th.ac.mahidol.ict.gemini7.model.SciencePlan, Long> {
    List<SciencePlan> findByStatus(String status);
}
