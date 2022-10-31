package shine.me.springsecuritycore.security.service;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import shine.me.springsecuritycore.domain.entity.Account;

import java.util.List;

@Data
public class AccountContext extends User {

    private Account account;

    public AccountContext(Account account, List<GrantedAuthority> roles) {
        super(account.getUsername(), account.getPassword(), roles);
        this.account = account;
    }
}
