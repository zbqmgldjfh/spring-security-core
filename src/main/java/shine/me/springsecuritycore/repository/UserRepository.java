package shine.me.springsecuritycore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shine.me.springsecuritycore.domain.Account;

public interface UserRepository extends JpaRepository<Account, Long> {

    Account findByUsername(String username);
}
