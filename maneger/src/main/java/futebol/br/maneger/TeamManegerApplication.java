package futebol.br.maneger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "futebol.br.maneger")
public class TeamManegerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeamManegerApplication.class, args);
	}

}
