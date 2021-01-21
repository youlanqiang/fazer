package top.youlanqiang.fazer.git;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.jgit.errors.RepositoryNotFoundException;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.ServiceMayNotContinueException;
import org.eclipse.jgit.transport.resolver.RepositoryResolver;
import org.eclipse.jgit.transport.resolver.ServiceNotAuthorizedException;
import org.eclipse.jgit.transport.resolver.ServiceNotEnabledException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author youlanqiang
 * created in 2020/12/14 22:08
 */
@Slf4j
public class GitHttpResolver implements RepositoryResolver<HttpServletRequest> {

    @Override
    public Repository open(HttpServletRequest req, String name) throws RepositoryNotFoundException,
            ServiceNotAuthorizedException, ServiceNotEnabledException,
            ServiceMayNotContinueException {
        log.info("path:" + req.getServletPath());
        log.info("name:"+name);
        try {
            return new FileRepository("/Users/youlanqiang/IdeaProjects/fazer/testUser/hello");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
