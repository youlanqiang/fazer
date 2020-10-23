package top.youlanqiang.fazer;


import com.google.common.collect.Sets;
import com.google.inject.Guice;
import com.google.inject.Injector;
import io.undertow.Undertow;
import io.undertow.servlet.api.DeploymentInfo;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;
import top.youlanqiang.fazer.controller.UserController;


import javax.ws.rs.core.Application;
import java.util.Set;


public class WebApplication  extends Application {

    public static void main(String[] args) {
        UndertowJaxrsServer
                server = new UndertowJaxrsServer();
        server.start(Undertow.builder().addHttpListener(8081,"localhost"));

        DeploymentInfo info = server.undertowDeployment(WebApplication.class)
                .setClassLoader(WebApplication.class.getClassLoader())
                .setContextPath("")
                .setDeploymentName("fazer");
        server.deploy(info);

    }

    @Override
    public Set<Object> getSingletons() {
        Injector injector = Guice.createInjector(new GuiceBindModule());
        Set<Object> set = Sets.newHashSet();
        set.add(injector.getInstance(UserController.class));
        return set;
    }
}
