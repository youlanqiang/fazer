package top.youlanqiang.fazer.module.auth.domain;

import org.springframework.security.core.GrantedAuthority;

public class BaseAuth implements GrantedAuthority {

    @Override
    public String getAuthority() {
        return null;
    }
}
