package top.youlanqiang.fazer.test;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import top.youlanqiang.fazer.module.auth.domain.BaseUser;
import top.youlanqiang.fazer.module.auth.repository.BaseUserRepository;

/**
 * @author youlanqiang
 * created in 2021/7/31 0:34
 */
@SpringBootTest
public class TestController {

    @Autowired
    BaseUserRepository repository;

    @Autowired
    PasswordEncoder encoder;

    @Test
    @DisplayName("测试用例-1")
    public void test1(){
        BaseUser user = new BaseUser();

        user.setEnabled(true);
        user.setNickname("admin");
        user.setPassword(encoder.encode("123456"));
        user.setUsername("admin");

        repository.save(user);
        System.out.println("测试构建");
    }
}
