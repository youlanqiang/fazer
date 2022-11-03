package top.youlanqiang.fazer.module.auth.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import top.youlanqiang.fazer.commons.domain.BaseDomain;

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

    @Column(name = "icon")
    @Schema(description = "icon图标")
    private String icon;

    @Enumerated(EnumType.STRING)
    @Schema(description = "权限类型")
    private AuthType authType;

    @Column(name = "component_path")
    @Schema(description = "组件路径")
    private String componentPath;

    @Column(name = "route_path")
    @Schema(description = "路由地址")
    private String routePath;

    @Column(name = "display", columnDefinition="boolean default true")
    @Schema(description = "是否显示")
    private boolean display = true;

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
        /**
         * 菜单
         */
        MENU,
        /**
         * 菜单项
         */
        SUBMENU,
        /**
         * 按钮
         */
        BUTTON,
        /**
         * URL权限
         */
        URL
    }
}
