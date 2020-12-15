package top.youlanqiang.fazer.git;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.jgit.http.server.GitFilter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

/**
 * @author youlanqiang
 * created in 2020/12/14 21:57
 */
@Slf4j
public class GitServlet extends org.eclipse.jgit.http.server.GitServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
      log.info("init ");
        setRepositoryResolver(new GitHttpResolver());
        super.init(config);
    }
}
