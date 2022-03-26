package top.youlanqiang.fazer.module.auth.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import top.youlanqiang.fazer.commons.domain.AjaxResult;
import top.youlanqiang.fazer.commons.base.BaseController;
import top.youlanqiang.fazer.module.auth.domain.BaseUser;
import top.youlanqiang.fazer.module.auth.service.IBaseUserService;

/**
 * @author youlanqiang
 * created in 2021/11/6 1:22 上午
 */
@Tag(name = "/user", description = "用户管理")
@RestController
@RequestMapping("/user")
@Slf4j
@AllArgsConstructor
public class BaseUserController extends BaseController<BaseUser, IBaseUserService> {



    @Operation( summary = "测试token令牌",security = @SecurityRequirement(name = "BearerAuth"))
    @GetMapping("/test")
    public AjaxResult test(){
        return AjaxResult.success();
    }



}
