package top.youlanqiang.fazer.config.jwt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.hash.Hashing;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import lombok.Data;
import org.apache.logging.log4j.util.Strings;
import org.springframework.util.Assert;
import top.youlanqiang.fazer.commons.utils.SpringUtils;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @author youlanqiang
 * @since 2022/08/07 22:06
 */
@Data
public final class JwtTokenBuilder {


    /**
     * 附加属性
     */
    private Map<String, String> additional;


    /**
     * jwt签发者
     */
    private String iss;

    /**
     * jwt面向的用户
     */
    private String sub;

    /**
     * 接收jwt的一方
     */
    private String aud;



    /**
     * jwt的签发时间
     */
    private final LocalDateTime iat;

    /**
     * jwt的过期时间，必须大于签发时间
     */
    private LocalDateTime exp;

    /**
     * 用户所有角色集合
     */
    private Set<String> roles = new HashSet<>();

    /**
     * 用户所有权限集合
     */
    private Set<String> permissions = new HashSet<>();

    /**
     * jwt的唯一身份标识，避免重放攻击
     */
    private final String jti = UUID.randomUUID().toString().replaceAll("-", Strings.EMPTY);


    public static JwtTokenBuilder create(){
        return new JwtTokenBuilder();
    }

    private JwtTokenBuilder(){
        LocalDateTime now = LocalDateTime.now();
        this.iat = now;
        this.exp = now;
    }

    public JwtTokenBuilder iss(String iss){
        this.iss = iss;
        return this;
    }

    public JwtTokenBuilder sub(String sub){
        this.sub = sub;
        return this;
    }

    public JwtTokenBuilder aud(String aud){
        this.aud = aud;
        return this;
    }

    public JwtTokenBuilder roles(Set<String> roles){
        this.roles.addAll(roles);
        return this;
    }

    public JwtTokenBuilder permissions(Set<String> permissions){
        this.permissions.addAll(permissions);
        return this;
    }

    public JwtTokenBuilder expDays(int days){
        Assert.isTrue(days > 0, "jwt expireDate must after now");
        this.exp = this.exp.plusDays(days);
        return this;
    }

    public JwtTokenBuilder expHours(int hours){
        Assert.isTrue(hours > 0, "jwt expireDate must after now");
        this.exp = this.exp.plusHours(hours);
        return this;
    }

    public JwtTokenBuilder expMinutes(int minutes){
        Assert.isTrue(minutes > 0, "jwt expireDate must after now");
        this.exp = this.exp.plusMinutes(minutes);
        return this;
    }

    public JwtTokenBuilder additional(Map<String, String> additional){
        this.additional = additional;
        return this;
    }

    public String build(JWSHeader jwsHeader,JWSSigner jwsSigner) throws JsonProcessingException, JOSEException {
        //创建JWS头，设置签名算法和类型
//        JWSHeader jwsHeader = new JWSHeader.Builder(JWSAlgorithm.HS256).type(JOSEObjectType.JWT).build();

        //将json信息封装到Payload中
        ObjectMapper objectMapper = SpringUtils.getBean(ObjectMapper.class);
        Payload payload = new Payload(objectMapper.writeValueAsString(this));

        //创建JWS对象
        JWSObject jwsObject = new JWSObject(jwsHeader, payload);

        //创建HMAC签名器
//        JWSSigner jwsSigner = new MACSigner(Hashing.sha256()
//                .hashString(secret, StandardCharsets.UTF_8).toString());

        jwsObject.sign(jwsSigner);
        return jwsObject.serialize();
    }
}
