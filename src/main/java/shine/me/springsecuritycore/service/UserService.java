package shine.me.springsecuritycore.service;

import shine.me.springsecuritycore.domain.dto.AccountDto;
import shine.me.springsecuritycore.domain.entity.Account;

import java.util.List;

public interface UserService {

    void createUser(Account account);

    void modifyUser(AccountDto accountDto);

    List<Account> getUsers();

    AccountDto getUser(Long id);

    void deleteUser(Long idx);
}
