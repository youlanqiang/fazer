package top.youlanqiang.fazer.common.utils;

import org.springframework.context.ApplicationContext;

/**
 * @author youlanqiang
 * created in 2021/3/1 23:29
 */
public final class SpringUtils {

    private static final SpringUtils HOLD = null;

    private static ApplicationContext context;

    private SpringUtils(){
        if(HOLD == null){
            throw new RuntimeException("Reject Reflection.");
        }
    }

    public static void setContext(final ApplicationContext applicationContext){
        if(applicationContext == null){
            throw new NullPointerException("application context is Null!");
        }

        context = applicationContext;
    }

    public static <T>  T getBean(Class<T> target){
        return context.getBean(target);
    }

}
