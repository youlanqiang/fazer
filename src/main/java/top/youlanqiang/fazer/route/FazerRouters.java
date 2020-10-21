package top.youlanqiang.fazer.route;


import io.undertow.Handlers;

import io.undertow.server.HttpHandler;
import top.youlanqiang.fazer.user.UserHandlers;

public class FazerRouters {


    public static HttpHandler get(){

        return Handlers.path()
                .addPrefixPath("/user", UserHandlers.get());

    }

}
