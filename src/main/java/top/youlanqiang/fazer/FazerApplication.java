package top.youlanqiang.fazer;




import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.youlanqiang.fazer.common.utils.SpringUtils;

/**
 * @author youlanqiang
 * created in 2021/1/21 18:55
 */

@SpringBootApplication
@RestController
public class FazerApplication  {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(FazerApplication.class, args);
        aware(context);
    }

    @GetMapping("/")
    public String hello(){
        return "If you see this page, the fazer web server is successfully working.";
    }




    public static void aware(ApplicationContext context){
        SpringUtils.setContext(context);
    }
}
