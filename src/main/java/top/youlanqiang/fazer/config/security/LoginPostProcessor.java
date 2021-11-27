package top.youlanqiang.fazer.config.security;

import javax.servlet.ServletRequest;

/**
 * @author youlanqiang
 * created in 2021/11/27 6:53 下午
 * 前置处理器接口
 */
public interface LoginPostProcessor {

    /**
     * 获取登陆类型
     * @return the type
     */
    LoginTypeEnum getLoginType();


    /**
     * 获得用户标识
     * @param request the request
     * @return the string
     */
    String obtainUsername(ServletRequest request);

    /**
     * 获取用户密码
     * @param request the request
     * @return the string
     */
    String obtainPassword(ServletRequest request);
}
