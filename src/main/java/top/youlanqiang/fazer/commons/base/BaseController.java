package top.youlanqiang.fazer.commons.base;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.*;
import top.youlanqiang.fazer.commons.domain.AjaxResult;
import top.youlanqiang.fazer.commons.domain.BaseDomain;

import javax.annotation.Resource;

/**
 * @author youlanqiang
 * created in 2022/3/27 00:32
 */
public class BaseController<T extends BaseDomain, S extends BaseService<T>> {

    @Resource
    S service;


    @Operation(security = @SecurityRequirement(name = "BearerAuth"))
    @PostMapping
    public AjaxResult saveOrUpdate(@RequestBody T t){
        return AjaxResult.success(service.saveOrUpdate(t));
    }

    @Operation(security = @SecurityRequirement(name = "BearerAuth"))
    @GetMapping("/{id}")
    public AjaxResult getById(@PathVariable String id){
        return AjaxResult.success(service.getById(id));
    }

    @Operation(security = @SecurityRequirement(name = "BearerAuth"))
    @DeleteMapping("/{id}")
    public AjaxResult removeById(@PathVariable String id){
        return AjaxResult.to(service.deleteById(id));
    }

    @Operation(security = @SecurityRequirement(name = "BearerAuth"))
    @GetMapping("/page/{pageNum}/{pageSize}")
    public AjaxResult page(@PathVariable Integer pageNum,
                           @PathVariable Integer pageSize){
        return AjaxResult.success(service.page(pageNum, pageSize));
    }

    public S service(){
        return service;
    }
}
