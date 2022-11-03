package top.youlanqiang.fazer.commons.utils;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import top.youlanqiang.fazer.module.auth.domain.BaseUser;

/**
 * @author youlanqiang
 * created in 2021/11/27 10:06 上午
 */
public final class SecurityUtils {

    public final static String ANONYMOUS = "anonymous";

    private SecurityUtils(){}

    public static Authentication getUser(){
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 获取当前登录用户名,匿名用户返回 anonymous
     * @return 用户名称
     */
    public static String getUserName(){
        Authentication authentication = getUser();
        if(authentication instanceof AnonymousAuthenticationToken){
            return ANONYMOUS;
        }
        return authentication.getName();
    }

    /**
     * 获取当前登录用户id,匿名用户返回 anonymous
     * @return 用户id
     */
    public static String getUserId(){
        Authentication authentication = getUser();
        if(authentication instanceof AnonymousAuthenticationToken){
            return ANONYMOUS;
        }
        return ((BaseUser)authentication.getPrincipal()).getUid();
    }


}
