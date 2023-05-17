package top.youlanqiang.fazer.module.auth.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author youlanqiang
 *         created in 2021/11/6 1:22 上午
 */
@Tag(name = "/user", description = "用户管理")
@RestController
@RequestMapping("/user")
@SecurityRequirement(name = "bearerAuth")
@Slf4j
@AllArgsConstructor
public class BaseUserController {

}
