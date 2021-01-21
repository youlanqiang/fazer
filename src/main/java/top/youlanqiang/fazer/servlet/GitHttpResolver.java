package top.youlanqiang.fazer.servlet;

import lombok.SneakyThrows;
import org.eclipse.jgit.errors.RepositoryNotFoundException;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.StoredConfig;
import org.eclipse.jgit.transport.ServiceMayNotContinueException;
import org.eclipse.jgit.transport.resolver.RepositoryResolver;
import org.eclipse.jgit.transport.resolver.ServiceNotAuthorizedException;
import org.eclipse.jgit.transport.resolver.ServiceNotEnabledException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author youlanqiang
 * created in 2021/1/21 19:50
 */
public class GitHttpResolver implements RepositoryResolver<HttpServletRequest> {


    @SneakyThrows
    @Override
    public Repository open(HttpServletRequest request, String name) throws RepositoryNotFoundException, ServiceNotAuthorizedException, ServiceNotEnabledException, ServiceMayNotContinueException {
        System.out.println("ServletPath: " + request.getServletPath());
        System.out.println("name: " + name);
        try {
            Repository repository = new FileRepository("G:\\test\\dev\\testUser\\hello\\.git");
            enableInsecureReceiving(repository);
            repository.incrementOpen();
            return repository;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void enableInsecureReceiving(Repository repository) {
        final StoredConfig config = repository.getConfig();
        config.setBoolean("http", null, "receivepack", true);
        try {
            config.save();
        } catch (IOException e) {
            throw new RuntimeException("Unable to save http.receivepack=true config", e);
        }
    }

}
