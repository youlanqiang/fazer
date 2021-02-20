package top.youlanqiang.fazer.module.auth.domain;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;



@Data
public class BaseAuth implements GrantedAuthority {


    private String authority;

    @Override
    public String getAuthority() {
        return null;
    }
}
