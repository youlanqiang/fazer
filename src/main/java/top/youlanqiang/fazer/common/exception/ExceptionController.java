package top.youlanqiang.fazer.common.exception;

import top.youlanqiang.fazer.common.entity.ResponseResult;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ExceptionController implements ExceptionMapper<Exception> {


    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public Response toResponse(Exception exception) {
        return ResponseResult.error("系统错误", exception.getMessage());
    }
}
