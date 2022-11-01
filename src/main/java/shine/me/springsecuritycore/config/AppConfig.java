package shine.me.springsecuritycore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import shine.me.springsecuritycore.repository.ResourcesRepository;
import shine.me.springsecuritycore.service.SecurityResourceService;

@Configuration
public class AppConfig {

    @Bean
    public SecurityResourceService securityResourceService(ResourcesRepository resourcesRepository) {
        SecurityResourceService securityResourceService = new SecurityResourceService(resourcesRepository);
        return securityResourceService;
    }
}
