package top.youlanqiang.fazer;


import com.google.common.collect.Sets;
import com.google.inject.Guice;
import com.google.inject.Injector;
import io.undertow.Undertow;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;
import top.youlanqiang.fazer.common.config.GuiceBindModule;
import top.youlanqiang.fazer.common.exception.ExceptionController;
import top.youlanqiang.fazer.controller.GitController;
import top.youlanqiang.fazer.controller.UserController;
import top.youlanqiang.fazer.git.GitServlet;


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
                .setDeploymentName("fazer")
                .addServlets(Servlets.servlet(GitServlet.class).addInitParam("message","hello world").addMapping("/git-servlet"));


        server.deploy(info);

    }

    @Override
    public Set<Class<?>> getClasses() {
        return Sets.newHashSet(ExceptionController.class);
    }

    @Override
    public Set<Object> getSingletons() {
        Injector injector = Guice.createInjector(new GuiceBindModule());
        Set<Object> set = Sets.newHashSet();
        set.add(injector.getInstance(UserController.class));
        set.add(injector.getInstance(GitController.class));
        return set;
    }
}
