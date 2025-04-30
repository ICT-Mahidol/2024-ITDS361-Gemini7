package th.ac.mahidol.ict.gemini7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th.ac.mahidol.ict.gemini7.model.User.Astronomer;

@Repository
public interface AstronomerRepository extends JpaRepository<Astronomer, Long> {

    // เพิ่ม method นี้เพื่อค้นหาด้วย username
    Astronomer findByUsername(String username);
}
