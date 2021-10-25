package top.youlanqiang.fazer.common.domain;


import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public final class AjaxResult {

    private int code;

    private String msg;

    private Object data;

    public AjaxResult(){}

    public AjaxResult(int code, String msg, Object data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static AjaxResult create(int code, String msg, Object data){
        return new AjaxResult(code, msg, data);
    }

    public static AjaxResult success(String msg, Object data){
        return create(HttpStatus.OK.value(), msg, data);
    }

    public static AjaxResult success(Object data){
        return success(HttpStatus.OK.getReasonPhrase(), data);
    }

    public static AjaxResult success(){
        return success(null);
    }

    public static AjaxResult error(String msg, Object data){
        return create(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg, data);
    }

    public static AjaxResult error(Object data){
        return error(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), data);
    }

    public static AjaxResult error(){
        return error(null);
    }


}
