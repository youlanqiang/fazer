package top.youlanqiang.fazer.user;

import io.undertow.Handlers;

import io.undertow.server.RoutingHandler;

public class UserHandlers {

    public static RoutingHandler get(){
        return Handlers.routing()
                //添加一个用户
                .post("/", exchange -> {})
                //获取一个用户
                .get("/{userId}",exchange -> {})
                //更新一个用户
                .put("/",exchange -> {})
                //删除一个用户
                .delete("/{userId}", exchange -> {});
    }

}
