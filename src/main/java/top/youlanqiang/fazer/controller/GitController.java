package top.youlanqiang.fazer.controller;

import top.youlanqiang.fazer.common.entity.ResponseResult;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author youlanqiang
 * created in 2020/12/14 21:14
 */
@Path("/git")
@Singleton
public class GitController {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseResult create(){
        return null;
    }

}
