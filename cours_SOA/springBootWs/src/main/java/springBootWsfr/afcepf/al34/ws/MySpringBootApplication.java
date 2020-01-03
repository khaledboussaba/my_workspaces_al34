package springBootWsfr.afcepf.al34.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MySpringBootApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		
		SpringApplication app = new SpringApplication(MySpringBootApplication.class);
		ConfigurableApplicationContext context = app.run(args);
		System.out.println("http://localhost:8080/springBootWsApp");
		
	}
	
}
