package shine.me.springsecuritycore.security.init;

import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.stereotype.Component;
import shine.me.springsecuritycore.service.RoleHierarchyService;

@Component
@AllArgsConstructor
public class SecurityInitializer implements ApplicationRunner {

    private RoleHierarchyService roleHierarchyService;
    private RoleHierarchyImpl roleHierarchy;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String allHierarchy = roleHierarchyService.findAllHierarchy();
        roleHierarchy.setHierarchy(allHierarchy);
    }
}
