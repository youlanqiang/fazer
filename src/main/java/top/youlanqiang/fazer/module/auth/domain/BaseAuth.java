package top.youlanqiang.fazer.module.auth.domain;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import top.youlanqiang.fazer.common.domain.BaseDomain;

import javax.persistence.Table;


@Data
@Table(name = "base_auth")
public class BaseAuth extends BaseDomain implements GrantedAuthority {


    private String authority;

    @Override
    public String getAuthority() {
        return null;
    }
}
