package top.youlanqiang.fazer.module.auth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import top.youlanqiang.fazer.module.auth.domain.BaseAuth;
import top.youlanqiang.fazer.module.auth.repository.BaseAuthRepository;
import top.youlanqiang.fazer.module.auth.service.IBaseAuthService;

/**
 * @author youlanqiang
 * created in 2021/11/21 11:17 下午
 */
@Service
public class BaseAuthServiceImpl implements IBaseAuthService {

    private final BaseAuthRepository authRepository;

    @Autowired
    public BaseAuthServiceImpl(BaseAuthRepository authRepository) {
        this.authRepository = authRepository;
    }


    public BaseAuth getAuthById(String id){
        Assert.notNull(id, "id不应该为空");
        BaseAuth auth = authRepository.getById(id);
        Assert.isNull(auth, "未发现id:"+id+" 的权限");
        return auth;
    }


}
