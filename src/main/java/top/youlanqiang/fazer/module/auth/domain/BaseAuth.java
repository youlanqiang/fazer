package top.youlanqiang.fazer.module.auth.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import top.youlanqiang.fazer.common.domain.BaseDomain;

import javax.persistence.*;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "base_auth")
public class BaseAuth extends BaseDomain implements GrantedAuthority {


    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", referencedColumnName = "uid")
    private List<BaseAuth> auths;

    @Column(name = "info")
    private String info;

    @Column(name = "authority")
    private String authority;

    @Override
    public String getAuthority() {
        return authority;
    }
}
