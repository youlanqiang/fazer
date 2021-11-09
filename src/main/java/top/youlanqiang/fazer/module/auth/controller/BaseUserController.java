package top.youlanqiang.fazer.module.auth.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.youlanqiang.fazer.common.domain.AjaxResult;

/**
 * @author youlanqiang
 * created in 2021/11/6 1:22 上午
 */
@RestController("/user")
@Tag(name = "用户管理", description = "用户管理")
public class BaseUserController {


    @Operation( summary = "测试token令牌",security = @SecurityRequirement(name = "BearerAuth"))
    @GetMapping("/test")
    public AjaxResult test(){
        return AjaxResult.success();
    }

}
