package top.youlanqiang.fazer.module.auth.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import top.youlanqiang.fazer.commons.domain.BaseDomain;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

// @Transient 在数据库中忽略这个字段

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "base_user")
public class BaseUser extends BaseDomain implements UserDetails {

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "account_non_expired")
    private boolean accountNonExpired;

    @Column(name = "account_non_locked")
    private boolean accountNonLocked;

    @Column(name = "credentials_non_expired")
    private boolean credentialsNonExpired;

    @Column(name = "enabled")
    private boolean enabled;

    /**
     * 多对多映射关系配置
     * 1.声明表关系的配置
     *  @ManyToMany(targetEntity= BaseRole.class)
     * 2.配置中间表(包含2个外键)
     * joinColumns 当前对象在中间表中的外键
     * inverseJoinColumns 对方对象在中间表的外键
     */
    @ManyToMany(targetEntity = BaseRole.class, fetch = FetchType.LAZY)
    @JoinTable(name = "base_user_role",
            joinColumns = {@JoinColumn(name = "user_id",referencedColumnName = "uid")},
            inverseJoinColumns = {@JoinColumn(name="role_id", referencedColumnName = "uid")})
    private Set<BaseRole> roleList;



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 使用jpa懒加载要在对应方法加上 @Transaction 注解
        Set<BaseAuth> authList = new HashSet<>();
        Set<BaseRole> roles = getRoleList();
        for (BaseRole role : roles) {
            Set<BaseAuth> auths = role.getAuthList();
            for (BaseAuth auth : auths) {
                deepPut(authList, auth);
            }
        }
        return authList;
    }

    private void deepPut(final Set<BaseAuth> authList, final BaseAuth baseAuth){
        if(baseAuth != null){
            authList.add(baseAuth);
            if(!baseAuth.getAuths().isEmpty()){
                baseAuth.getAuths().stream().forEach(item->{
                    deepPut(authList, item);
                });
            }
        }
    }
}
