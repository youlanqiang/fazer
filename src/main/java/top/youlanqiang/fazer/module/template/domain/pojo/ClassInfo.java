package top.youlanqiang.fazer.module.template.domain.pojo;

import lombok.Data;
import top.youlanqiang.fazer.module.template.commons.TemplateCategory;

/**
 * @author youlanqiang
 * created in 2022/3/2 10:59 上午
 * 类信息
 */
@Data
public class ClassInfo {

    // 模块名称
    private String moduleName;

    // 项目名称
    private String projectName;

    // 类别名称
    private TemplateCategory categoryName;

    // 类名
    private String clazzName;


}
