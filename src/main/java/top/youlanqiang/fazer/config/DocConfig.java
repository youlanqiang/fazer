package top.youlanqiang.fazer.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author youlanqiang
 * created in 2021/11/6 2:10 上午
 */
@Configuration
@SecurityScheme(
        name = "BearerAuth",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
public class DocConfig {

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .info(new Info().title("Fazer API")
                        .description("Build your app in Fazer Platform")
                        .version("v0.0.1"));
    }
}
