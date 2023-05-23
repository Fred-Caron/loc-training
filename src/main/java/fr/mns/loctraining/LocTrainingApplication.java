package fr.mns.loctraining;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class LocTrainingApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocTrainingApplication.class, args);
	}

}
