package top.youlanqiang.fazer.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Aspect
@Component
@Slf4j
public class RequestAspect {

    @Pointcut("execution(public * top.youlanqiang.fazer.module.*.controller.*(..))")
    public void tag(){}

    @Before("tag()")
    public void doBefore(JoinPoint joinPoint){
        log.info("=== log start ===");
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        log.info("url={}",request.getRequestURI());
        log.info("method={}", request.getMethod());
        log.info("ip={}",request.getRemoteAddr());
        Enumeration<String> paramter = request.getParameterNames();
        while (paramter.hasMoreElements()) {
            String str = (String) paramter.nextElement();
            log.info(str + "={}", request.getParameter(str));
        }
        log.info("=== log end ===");
    }
}
