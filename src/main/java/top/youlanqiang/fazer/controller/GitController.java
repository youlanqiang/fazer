package top.youlanqiang.fazer.controller;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import top.youlanqiang.fazer.common.entity.ResponseResult;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;

/**
 * @author youlanqiang
 * created in 2020/12/14 21:14
 */
@Path("/git")
@Singleton
public class GitController {

    @GET
    @Path("/init/{projectName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("projectName") String projectName) throws GitAPIException {
        File file = new File("./testUser/"+projectName);
        file.mkdirs();
        Git.init().setDirectory(file).call();

        return ResponseResult.success("成功.",null);
    }



}
