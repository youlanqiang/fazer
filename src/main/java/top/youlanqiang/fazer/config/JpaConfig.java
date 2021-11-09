package top.youlanqiang.fazer.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


import java.util.Optional;

/**
 * @author youlanqiang
 * created in 2021/2/24 11:22
 */
@Configuration
@EntityScan("top.youlanqiang.fazer.module.*.domain")
@EnableJpaRepositories(basePackages = "top.youlanqiang.fazer.module.*.repository")
@EnableJpaAuditing   //开启jpa自动填充数据 如 createBy ..
public class JpaConfig {


    @Bean
    public AuditorAware<String> getAuditorAware() {
        //自动填充userId
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null){
            return ()->Optional.of("admin");
        }
        return () -> Optional.of( authentication.getPrincipal().toString());
    }
}
