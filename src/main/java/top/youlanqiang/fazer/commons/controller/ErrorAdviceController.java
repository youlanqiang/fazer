package top.youlanqiang.fazer.commons.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.youlanqiang.fazer.commons.domain.AjaxResult;

/**
 * @author youlanqiang
 * created in 2021/11/21 11:31 下午
 * 全局异常处理
 */
@RestControllerAdvice
public class ErrorAdviceController {

    @ExceptionHandler(RuntimeException.class)
    public AjaxResult handleException(RuntimeException e){
        return AjaxResult.error(e.getMessage(), null);
    }

}
