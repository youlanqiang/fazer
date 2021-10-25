package top.youlanqiang.fazer;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;
import top.youlanqiang.fazer.common.utils.SpringUtils;

/**
 * @author youlanqiang
 * created in 2021/1/21 18:55
 */

@SpringBootApplication
public class FazerApplication  {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(FazerApplication.class, args);
        aware(context);
    }


    public static void aware(ApplicationContext context){
        SpringUtils.setContext(context);
    }
}
