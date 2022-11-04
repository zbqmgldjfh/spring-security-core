package shine.me.springsecuritycore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shine.me.springsecuritycore.domain.entity.RoleHierarchy;

public interface RoleHierarchyRepository extends JpaRepository<RoleHierarchy, Long> {

    RoleHierarchy findByChildName(String roleName);
}
