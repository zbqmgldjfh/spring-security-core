package shine.me.springsecuritycore.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import shine.me.springsecuritycore.domain.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRoleName(String name);

    @Override
    void delete(Role role);

}
