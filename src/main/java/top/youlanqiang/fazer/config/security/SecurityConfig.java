package top.youlanqiang.fazer.config.security;


import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.annotation.Resource;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/**
 * @author youlanqiang
 * created in 2021/1/21 23:25
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {



    @Value("${jwt.public.key}")
    RSAPublicKey publicKey;
    
    @Value("${jwt.private.key}")
    RSAPrivateKey privateKey;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }



    // 自定义权限不足处理器
    @Resource
    CustomAccessDeniedHandler accessDeniedHandler;

    //用来解决匿名用户访问无权限资源时的异常
    @Resource
    CustomAuthenticationEntryPoint authenticationEntryPoint;


    @Resource
    UserDetailsService userDetailsService;





    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeRequests((auth) -> auth.antMatchers("/login").anonymous()
                .antMatchers(HttpMethod.GET, "/").permitAll()
                .antMatchers("/swagger-ui/**","/swagger-ui.html", "/v3/api-docs/**").permitAll()
                .anyRequest().authenticated())
                .sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .exceptionHandling((exceptions) ->
                        exceptions.authenticationEntryPoint(authenticationEntryPoint)
                                .accessDeniedHandler(accessDeniedHandler)
                ).formLogin().loginProcessingUrl("/login").and()
                .authenticationProvider(new LoginValidateAuthenticationProvider(passwordEncoder(), userDetailsService))
                .build();
    }





    
}
