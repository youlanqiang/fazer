package top.youlanqiang.fazer.module.auth.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.youlanqiang.fazer.commons.base.BaseController;
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
@AllArgsConstructor
public class BaseAuthController extends BaseController<BaseAuth, IBaseAuthService> {





}
