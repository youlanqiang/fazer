package test.youlanqiang.fazer;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author youlanqiang
 * created in 2021/7/31 0:34
 */
@SpringBootTest
public class TestController {

    @Test
    @Tag("测试用例-1")
    public void test1(){
        System.out.println("测试构建");
    }
}
