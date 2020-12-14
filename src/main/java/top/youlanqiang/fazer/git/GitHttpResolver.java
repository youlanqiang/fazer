package top.youlanqiang.fazer.git;

import lombok.SneakyThrows;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.resolver.RepositoryResolver;
import javax.servlet.http.HttpServletRequest;

/**
 * @author youlanqiang
 * created in 2020/12/14 22:08
 */
public class GitHttpResolver implements RepositoryResolver<HttpServletRequest> {
    @SneakyThrows
    @Override
    public Repository open(HttpServletRequest req, String name) {
        System.out.println("path:" + req.getServletPath());
        System.out.println("name:"+name);
        return new FileRepository("");
    }
}
