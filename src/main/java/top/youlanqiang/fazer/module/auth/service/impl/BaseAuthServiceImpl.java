package top.youlanqiang.fazer.module.auth.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import top.youlanqiang.fazer.commons.base.BaseServiceImpl;
import top.youlanqiang.fazer.module.auth.domain.BaseAuth;
import top.youlanqiang.fazer.module.auth.repository.BaseAuthRepository;
import top.youlanqiang.fazer.module.auth.service.IBaseAuthService;

/**
 * @author youlanqiang
 *         created in 2021/11/21 11:17 下午
 */
@Service
@AllArgsConstructor
public class BaseAuthServiceImpl extends BaseServiceImpl<BaseAuth, BaseAuthRepository> implements IBaseAuthService {

    private final BaseAuthRepository authRepository;

    public BaseAuth getAuthById(String id) {
        Assert.notNull(id, "id不应该为空");
        BaseAuth auth = authRepository.getReferenceById(id);
        Assert.isNull(auth, "未发现id:" + id + " 的权限");
        return auth;
    }
}
