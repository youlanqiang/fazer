package top.youlanqiang.fazer.module.template.commons;

import org.springframework.util.ResourceUtils;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.FileTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.io.FileNotFoundException;

/**
 * @author youlanqiang
 * created in 2022/1/15 11:21 下午
 */
public enum ThymeleafUtils {
    INSTANCE;

    private final TemplateEngine templateEngine;

    ThymeleafUtils() {
        FileTemplateResolver resolver = new FileTemplateResolver();
        try{
            resolver.setPrefix(ResourceUtils.getURL("classpath:templates/").getFile());
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        resolver.setTemplateMode(TemplateMode.TEXT);
        templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(resolver);
    }

    public static TemplateEngine getTemplateEngine(){
        return INSTANCE.templateEngine;
    }

}
