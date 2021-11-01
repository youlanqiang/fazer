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
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.oauth2.server.resource.web.BearerTokenAuthenticationEntryPoint;
import org.springframework.security.oauth2.server.resource.web.access.BearerTokenAccessDeniedHandler;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/**
 * @author youlanqiang
 * created in 2021/1/21 23:25
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {



//    HttpBasic模式的原理说明
//    首先，HttpBasic模式要求传输的用户名密码使用Base64模式进行加密。如果用户名是 "admin"  ，密码是“ admin”，则将字符串"admin:admin"使用Base64编码算法加密。加密结果可能是：YWtaW46YWRtaW4=。
//    然后，在Http请求中使用Authorization作为一个Header，“Basic YWtaW46YWRtaW4=“作为Header的值，发送给服务端。（注意这里使用Basic+空格+加密串）
//    服务器在收到这样的请求时，到达BasicAuthenticationFilter过滤器，将提取“ Authorization”的Header值，并使用用于验证用户身份的相同算法Base64进行解码。
//    解码结果与登录验证的用户名密码匹配，匹配成功则可以继续过滤器后续的访问。

    


//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.httpBasic() //开启HttpBasic 认证
//                .and()
//                .authorizeRequests()
//                .anyRequest().authenticated();
//        
//    }

    @Value("${jwt.public.key}")
    RSAPublicKey publicKey;
    
    @Value("${jwt.private.key}")
    RSAPrivateKey privateKey;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtDecoder jwtDecoder(){
        return NimbusJwtDecoder.withPublicKey(publicKey).build();
    }

    @Bean
    public JwtEncoder jwtEncoder(){
        JWK jwk = new RSAKey.Builder(publicKey)
                .privateKey(privateKey).build();
        JWKSource<SecurityContext>  jwkSource = new ImmutableJWKSet<>(new JWKSet(jwk));
        return new NimbusJwtEncoder(jwkSource);
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(auth -> auth.antMatchers("/token").permitAll().anyRequest().authenticated())
                .csrf(csrf -> csrf.ignoringAntMatchers("/token") )
                .httpBasic(Customizer.withDefaults())
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .exceptionHandling(exceptions ->
                        exceptions.authenticationEntryPoint(new BearerTokenAuthenticationEntryPoint())
                                .accessDeniedHandler(new BearerTokenAccessDeniedHandler())
                );

    }


    
}
