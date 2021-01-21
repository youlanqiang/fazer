package top.youlanqiang.fazer.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;


/**
 * @author youlanqiang
 * created in 2021/1/21 19:03
 */
@ServletSecurity(@HttpConstraint(rolesAllowed = "R1"))
@WebServlet(name = "gitServer",
        urlPatterns = {"/git/*"}, loadOnStartup = 1,
        initParams = {
                @WebInitParam(name = "base-path", value = "G:\\test\\dev"),
                @WebInitParam(name = "export-all", value = "true")
        }
)
public class GitServlet extends org.eclipse.jgit.http.server.GitServlet {

        @Override
        public void init(ServletConfig config) throws ServletException {
                setRepositoryResolver(new GitHttpResolver());
                super.init(config);
        }

}
