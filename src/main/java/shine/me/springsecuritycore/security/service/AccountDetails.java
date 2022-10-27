package shine.me.springsecuritycore.security.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import shine.me.springsecuritycore.domain.Account;

import java.util.Collection;

public class AccountDetails extends User {

    private final Account account;

    public AccountDetails(Account account, Collection<? extends GrantedAuthority> authorities) {
        super(account.getUsername(), account.getPassword(), authorities);
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }
}
