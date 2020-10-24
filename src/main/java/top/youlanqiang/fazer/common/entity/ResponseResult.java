package top.youlanqiang.fazer.common.entity;


import lombok.Data;

import javax.ws.rs.core.Response;

@Data
public class ResponseResult {

    private Integer code;

    private String msg;

    private Object data;

    public static ResponseResult create(Integer code, String msg, Object data){
        ResponseResult result = new ResponseResult();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }


    public static Response success(String msg, Object data){
        return Response.ok().entity(create(200, msg, data)).build();
    }

    public static Response error(String msg, Object data){
        return Response.ok().entity(create(500, msg, data)).build();
    }


}
