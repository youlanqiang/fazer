package top.youlanqiang.fazer.module.auth.service;

import top.youlanqiang.fazer.module.auth.domain.BaseAuth;

/**
 * @author youlanqiang
 * created in 2021/11/21 11:17 下午
 */
public interface IBaseAuthService {

    BaseAuth getAuthById(String id);
}
