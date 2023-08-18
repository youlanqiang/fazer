package top.youlanqiang.fazer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;

/**
 * @author youlanqiang
 *         created in 2021/1/21 18:55
 */

@SpringBootApplication
@RestController
public class FazerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FazerApplication.class, args);
    }

    @Bean
    RouterFunction<ServerResponse> hello() {
        return RouterFunctions.route()
                .GET("/hello", request -> {
                    return ServerResponse.ok().body("Fazer is running!");
                })
                .build();
    }

}
