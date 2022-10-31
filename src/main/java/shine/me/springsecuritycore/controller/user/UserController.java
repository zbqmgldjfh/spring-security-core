package shine.me.springsecuritycore.controller.user;


import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import shine.me.springsecuritycore.domain.entity.Account;
import shine.me.springsecuritycore.domain.dto.AccountDto;
import shine.me.springsecuritycore.service.UserService;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final PasswordEncoder passwordEncoder; 
    private final UserService userService;

    @GetMapping("/mypage")
    public String myPage() throws Exception {
        return "user/mypage";
    }
	
    @GetMapping("/users")
    public String createUser() {
        return "user/login/register";
    }

    @PostMapping("/users")
    public String registerUser(AccountDto accountDto) {
        ModelMapper modelMapper = new ModelMapper();
        Account account = modelMapper.map(accountDto, Account.class);
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        userService.createUser(account);
        return "redirect:/";
    }
}
