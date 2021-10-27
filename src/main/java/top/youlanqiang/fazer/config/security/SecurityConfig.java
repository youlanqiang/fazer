package top.youlanqiang.fazer.config.security;

import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.KeyUse;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.jwk.source.RemoteJWKSet;
import com.nimbusds.jose.proc.*;
import com.nimbusds.jose.util.Base64URL;
import com.nimbusds.jwt.proc.ConfigurableJWTProcessor;
import com.nimbusds.jwt.proc.DefaultJWTProcessor;
import com.nimbusds.jwt.proc.JWTProcessor;
import lombok.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import top.youlanqiang.fazer.module.auth.repository.BaseUserRepository;

import javax.annotation.Resource;
import java.net.URL;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;

/**
 * @author youlanqiang
 * created in 2021/1/21 23:25
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {



//    HttpBasic模式的原理说明
//    首先，HttpBasic模式要求传输的用户名密码使用Base64模式进行加密。如果用户名是 "admin"  ，密码是“ admin”，则将字符串"admin:admin"使用Base64编码算法加密。加密结果可能是：YWtaW46YWRtaW4=。
//    然后，在Http请求中使用Authorization作为一个Header，“Basic YWtaW46YWRtaW4=“作为Header的值，发送给服务端。（注意这里使用Basic+空格+加密串）
//    服务器在收到这样的请求时，到达BasicAuthenticationFilter过滤器，将提取“ Authorization”的Header值，并使用用于验证用户身份的相同算法Base64进行解码。
//    解码结果与登录验证的用户名密码匹配，匹配成功则可以继续过滤器后续的访问。




    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic() //开启HttpBasic 认证
                .and()
                .authorizeRequests()
                .anyRequest().authenticated();
    }



}
