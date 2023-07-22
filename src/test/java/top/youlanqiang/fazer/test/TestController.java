package top.youlanqiang.fazer.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * @author youlanqiang
 *         created in 2021/7/31 0:34
 */
@SpringBootTest
public class TestController {

     @Test
     void test2(){
          System.out.println("hello world");
     }

     @Test
     void test1() {
          System.out.println("start");
          int count = getCount();
          System.out.println(count);
          System.out.println("end");
     }

     static int getCount() {
          int i = 1 + 1;
          i = 3;
          return i;
     }
}
