package top.youlanqiang.fazer.module.auth.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.youlanqiang.fazer.common.domain.AjaxResult;
import top.youlanqiang.fazer.module.auth.domain.BaseAuth;
import top.youlanqiang.fazer.module.auth.service.IBaseAuthService;

/**
 * @author youlanqiang
 * created in 2021/11/6 1:22 上午
 */
@Tag(name = "/auth", description = "权限管理")
@RestController
@RequestMapping("/auth")
@Slf4j
public class BaseAuthController {

    private final IBaseAuthService authService;

    @Autowired
    public BaseAuthController(IBaseAuthService authService) {
        this.authService = authService;
    }


    @Operation( summary = "获取对应id的权限",security = @SecurityRequirement(name = "BearerAuth"))
    @GetMapping("/{id}")
    public AjaxResult get(@PathVariable String id){
        return AjaxResult.success(authService.getAuthById(id));
    }
}
