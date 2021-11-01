package top.youlanqiang.fazer.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author youlanqiang
 * created in 2021/11/1 10:17 下午
 */
@Component
public class LoginValidateAuthenticationProvider implements AuthenticationProvider {


    UserDetailsService userDetailsService;

    PasswordEncoder passwordEncoder;

    @Autowired
    public LoginValidateAuthenticationProvider(@Qualifier("baseUserServiceImpl") UserDetailsService userDetailsService,
                                               PasswordEncoder passwordEncoder){


    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
