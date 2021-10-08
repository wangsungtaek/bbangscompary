package bangsCompany.bangsCompany;

import bangsCompany.bangsCompany.main.repository.MainRepository;
import bangsCompany.bangsCompany.main.repository.MemoryMainRepository;
import bangsCompany.bangsCompany.main.service.MainService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MainService mainService() {
        return new MainService(mainRepository());
    }

    @Bean
    public MainRepository mainRepository() {
        return new MemoryMainRepository();
    }
}
