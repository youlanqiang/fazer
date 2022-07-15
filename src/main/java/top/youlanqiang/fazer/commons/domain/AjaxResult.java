package top.youlanqiang.fazer.commons.domain;


import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public final class AjaxResult<T> {

    private int code;

    private String msg;

    private T data;

    public AjaxResult(){}

    public AjaxResult(int code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static AjaxResult<Void> to(boolean bool){
        if(bool){
            return success();
        }else{
            return error();
        }
    }

    public static AjaxResult<Void> create(int code, String msg){
        return create(code, msg, null);
    }

    public static <T> AjaxResult<T> create(int code, String msg, T data){
        return new AjaxResult<>(code, msg, data);
    }

    public static <T> AjaxResult<T> success(String msg, T data){
        return create(HttpStatus.OK.value(), msg, data);
    }

    public static <T> AjaxResult<T> success(T data){
        return success(HttpStatus.OK.getReasonPhrase(), data);
    }

    public static AjaxResult<Void> success(){
        return success(null);
    }

    public static <T> AjaxResult<T> error(String msg, T data){
        return create(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg, data);
    }

    public static <T> AjaxResult<T> error(T data){
        return error(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), data);
    }

    public static AjaxResult<Void> error(){
        return error(null);
    }

}
