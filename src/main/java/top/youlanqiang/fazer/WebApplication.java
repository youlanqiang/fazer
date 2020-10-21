package top.youlanqiang.fazer;


import io.undertow.Undertow;
import io.undertow.security.api.AuthenticationMode;
import io.undertow.security.handlers.SecurityInitialHandler;
import top.youlanqiang.fazer.route.FazerRouters;


public class WebApplication  {

    public static void main(String[] args) {

        Undertow undertow = Undertow.builder()
                .addHttpListener(8080,"localhost")
                .setHandler(new SecurityInitialHandler(AuthenticationMode.CONSTRAINT_DRIVEN,null,FazerRouters.get()))
                .build();

        undertow.start();

    }


}
