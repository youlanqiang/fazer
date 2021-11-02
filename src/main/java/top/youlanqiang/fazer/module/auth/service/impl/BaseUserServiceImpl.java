package top.youlanqiang.fazer.module.auth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import top.youlanqiang.fazer.module.auth.domain.BaseUser;
import top.youlanqiang.fazer.module.auth.repository.BaseAuthRepository;
import top.youlanqiang.fazer.module.auth.repository.BaseGroupRepository;
import top.youlanqiang.fazer.module.auth.repository.BaseUserRepository;
import top.youlanqiang.fazer.module.auth.service.IBaseUserService;

/**
 * @author youlanqiang
 * created in 2021/10/27 11:00 下午
 */
@Service
public class BaseUserServiceImpl implements IBaseUserService {

    BaseUserRepository userRepository;

    BaseGroupRepository groupRepository;


    BaseAuthRepository authRepository;

    @Autowired
    public BaseUserServiceImpl(BaseUserRepository userRepository,
                               BaseGroupRepository groupRepository,
                               BaseAuthRepository authRepository){
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
        this.authRepository = authRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        BaseUser user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException(username);
        }
        return user;
    }


}
