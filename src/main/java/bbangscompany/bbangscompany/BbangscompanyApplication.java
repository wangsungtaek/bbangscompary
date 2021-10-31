package bbangscompany.bbangscompany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class BbangscompanyApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BbangscompanyApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

		return application.sources(ServletInitializer.class);
	}

}
