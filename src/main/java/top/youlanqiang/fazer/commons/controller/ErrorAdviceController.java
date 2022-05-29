package top.youlanqiang.fazer.commons.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.youlanqiang.fazer.commons.domain.AjaxResult;
import top.youlanqiang.fazer.commons.error.ServiceException;

/**
 * @author youlanqiang
 * created in 2021/11/21 11:31 下午
 * 全局异常处理
 */
@RestControllerAdvice
@Slf4j
public class ErrorAdviceController {

    @ExceptionHandler(ServiceException.class)
    public AjaxResult handleException(ServiceException e){
        log.error(e.toString());
        return AjaxResult.error(e.getMessage(), null);
    }

}
