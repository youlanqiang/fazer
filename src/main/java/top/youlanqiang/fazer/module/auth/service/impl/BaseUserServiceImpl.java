package top.youlanqiang.fazer.module.auth.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import top.youlanqiang.fazer.commons.base.BaseServiceImpl;
import top.youlanqiang.fazer.module.auth.domain.BaseUser;
import top.youlanqiang.fazer.module.auth.repository.BaseUserRepository;
import top.youlanqiang.fazer.module.auth.service.IBaseUserService;

/**
 * @author youlanqiang
 * created in 2021/10/27 11:00 下午
 */
@Service
@AllArgsConstructor
public class BaseUserServiceImpl extends BaseServiceImpl<BaseUser, BaseUserRepository> implements IBaseUserService {


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        BaseUser user = repository().findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException(username);
        }
        return user;
    }


}
