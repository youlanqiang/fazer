package top.youlanqiang.fazer.module.auth.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import top.youlanqiang.fazer.common.domain.BaseDomain;

import javax.persistence.Table;
import java.util.Collection;


@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "base_user")
public class BaseUser extends BaseDomain implements UserDetails {

    private String username;

    private String password;

    private boolean accountNonExpired;

    private boolean accountNonLocked;

    private boolean credentialsNonExpired;

    private boolean enabled;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

}
