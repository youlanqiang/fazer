package top.youlanqiang.fazer.module.auth.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import top.youlanqiang.fazer.common.domain.BaseDomain;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "base_auth")
@Schema(description = "权限标识")
public class BaseAuth extends BaseDomain implements GrantedAuthority {


    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", referencedColumnName = "uid")
    private List<BaseAuth> auths;


    @Column(name = "info")
    @Schema(description = "备注")
    private String info;

    @Column(name = "authority")
    @Schema(description = "权限标识")
    private String authority;


    @Column(name = "sort", columnDefinition = "int default 0")
    private Integer sort;


    @ManyToMany(targetEntity = BaseRole.class, fetch = FetchType.LAZY)
    @JoinTable(name = "base_role_auth",
            joinColumns = {@JoinColumn(name = "auth_id",referencedColumnName = "uid")},
            inverseJoinColumns = {@JoinColumn(name="role_id", referencedColumnName = "uid")})
    private Set<BaseRole> roleList;

    @Override
    public String getAuthority() {
        return authority;
    }


    public enum AuthType{
        MENU,
        BUTTON,
        URL
    }
}
