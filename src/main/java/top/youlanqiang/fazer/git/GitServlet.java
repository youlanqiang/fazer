package top.youlanqiang.fazer.git;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

/**
 * @author youlanqiang
 * created in 2020/12/14 21:57
 */
public class GitServlet extends org.eclipse.jgit.http.server.GitServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        setRepositoryResolver(new GitHttpResolver());
        super.init();
    }
}
