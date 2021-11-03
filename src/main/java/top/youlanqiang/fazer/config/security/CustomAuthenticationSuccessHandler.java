package top.youlanqiang.fazer.config.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author youlanqiang
 * created in 2021/11/4 12:35 上午
 *
 * 认证成功处理器
 * 决定 响应JSON还是跳转页面，或者认证成功后进行其他处理
 */
@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        //todo 完成返回jwt令牌等操作
    }
}
