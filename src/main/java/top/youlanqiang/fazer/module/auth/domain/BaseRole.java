package top.youlanqiang.fazer.module.auth.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.youlanqiang.fazer.commons.domain.BaseDomain;

import javax.persistence.*;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "base_role")
public class BaseRole extends BaseDomain {


    @Column(name = "info")
    private String info;

    @Column(name = "sort", columnDefinition = "int default 0")
    private Integer sort;

    @ManyToMany(targetEntity = BaseUser.class, fetch = FetchType.LAZY)
    @JoinTable(name = "base_user_role",
            joinColumns = {@JoinColumn(name = "role_id",referencedColumnName = "uid")},
            inverseJoinColumns = {@JoinColumn(name="user_id", referencedColumnName = "uid")})
    private Set<BaseUser> userList;

    @ManyToMany(targetEntity = BaseAuth.class, fetch = FetchType.LAZY)
    @JoinTable(name = "base_role_auth",
            joinColumns = {@JoinColumn(name = "role_id",referencedColumnName = "uid")},
            inverseJoinColumns = {@JoinColumn(name="auth_id", referencedColumnName = "uid")})
    private Set<BaseAuth> authList;


}
