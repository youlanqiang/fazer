package top.youlanqiang.fazer.test;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.youlanqiang.fazer.module.auth.repository.BaseUserRepository;

/**
 * @author youlanqiang
 * created in 2021/7/31 0:34
 */
@SpringBootTest
public class TestController {

    @Autowired
    BaseUserRepository repository;

    @Test
    @Tag("测试用例-1")
    public void test1(){
        repository.findById("111");
        System.out.println("测试构建");
    }
}
