package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"application","controllers","services"})
@EntityScan(basePackages ={"entities"})
@EnableJpaRepositories(basePackages = {"repositories"})
public class DissPrApplication {

	public static void main(String[] args) {
		SpringApplication.run(DissPrApplication.class, args);
	}

}
