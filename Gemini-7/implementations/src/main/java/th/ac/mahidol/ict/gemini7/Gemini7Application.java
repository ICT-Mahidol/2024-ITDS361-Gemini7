package th.ac.mahidol.ict.gemini7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("th.ac.mahidol.ict.gemini7.repository")
@EntityScan({"th.ac.mahidol.ict.gemini7.model", "edu.gemini.app.ocs.model"})  // รวมทั้งสอง package
public class Gemini7Application {

	public static void main(String[] args) {
		SpringApplication.run(Gemini7Application.class, args);
	}

}
