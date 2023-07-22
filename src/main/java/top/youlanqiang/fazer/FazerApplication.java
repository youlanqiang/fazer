package top.youlanqiang.fazer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author youlanqiang
 * created in 2021/1/21 18:55
 */

@SpringBootApplication
@RestController
public class FazerApplication  {

    public static void main(String[] args) {
        SpringApplication.run(FazerApplication.class, args);
    }

    @GetMapping("/")
    public String hello(){
        return "If you see this page, the fazer web server is successfully working.";
    }

}
