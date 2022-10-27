package shine.me.springsecuritycore.security.provider;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import shine.me.springsecuritycore.domain.Account;
import shine.me.springsecuritycore.security.service.AccountDetails;

@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String rawPassword = (String) authentication.getCredentials();

        AccountDetails accountDetails = (AccountDetails) userDetailsService.loadUserByUsername(username);
        Account account = accountDetails.getAccount();

        if (!passwordEncoder.matches(rawPassword, account.getPassword())) {
            throw new BadCredentialsException("인증정보가 일치하지 않습니다.");
        }

        return new UsernamePasswordAuthenticationToken(account, null, accountDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
