package top.youlanqiang.fazer.module.template.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author youlanqiang
 * created in 2022/3/2 10:56 上午
 */
@Tag(name = "/gen", description = "代码生成管理")
@RestController
@RequestMapping("/gen")
@Slf4j
@AllArgsConstructor
public class GeneratorController {
}
