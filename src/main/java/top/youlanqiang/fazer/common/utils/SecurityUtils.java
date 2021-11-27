package top.youlanqiang.fazer.common.utils;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import top.youlanqiang.fazer.module.auth.domain.BaseUser;

/**
 * @author youlanqiang
 * created in 2021/11/27 10:06 上午
 */
public final class SecurityUtils {

    private SecurityUtils(){}

    public static Authentication getUser(){
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public static String getUserName(){
        Authentication authentication = getUser();
        if(authentication instanceof AnonymousAuthenticationToken){
            return "anonymous";
        }
        return authentication.getName();
    }

    public static String getUserId(){
        Authentication authentication = getUser();
        if(authentication instanceof AnonymousAuthenticationToken){
            return "anonymous";
        }
        return ((BaseUser)authentication.getPrincipal()).getUid();
    }


}
