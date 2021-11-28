package top.youlanqiang.fazer.config.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author youlanqiang
 * created in 2021/11/2 8:34 下午
 */
@Component
@Slf4j
public class LoginValidateAuthenticationProvider implements AuthenticationProvider {

    PasswordEncoder passwordEncoder;

    UserDetailsService userDetailsService;

    private final UserDetailsChecker checker =  new AccountStatusUserDetailsChecker();

    @Lazy
    @Autowired
    public LoginValidateAuthenticationProvider(PasswordEncoder encoder,@Qualifier("baseUserServiceImpl") UserDetailsService userDetailsService){
        this.passwordEncoder =encoder;
        this.userDetailsService = userDetailsService;
    }


    @Override
    @Transactional
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        log.info("username:{} password:{}", username, password);
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if (passwordEncoder.matches(password, userDetails.getPassword())) {
            // 检查UserDetails的状态
            //checker.check(userDetails);
            return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
