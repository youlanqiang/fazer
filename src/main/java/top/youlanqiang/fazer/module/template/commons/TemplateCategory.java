package top.youlanqiang.fazer.module.template.commons;

/**
 * @author youlanqiang
 * created in 2022/3/2 11:04 上午
 *
 */
public enum TemplateCategory {

    CONTROLLER("controller"),
    DOMAIN("domain"),
    REPOSITORY("repository"),
    SERVICE("service");



    private final String name;

    TemplateCategory(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
