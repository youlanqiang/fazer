package top.youlanqiang.fazer.module.template.commons;

import org.springframework.util.ResourceUtils;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.FileTemplateResolver;

import java.io.FileNotFoundException;

/**
 * @author youlanqiang
 */
public enum ThymeleafUtils {
    INSTANCE;

    private final TemplateEngine templateEngine;

    ThymeleafUtils() {
        FileTemplateResolver resolver = new FileTemplateResolver();
        try {
            resolver.setPrefix(ResourceUtils.getURL("classpath:templates/").getFile());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        resolver.setTemplateMode(TemplateMode.TEXT);
        templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(resolver);
    }

    public static TemplateEngine getTemplateEngine() {
        return INSTANCE.templateEngine;
    }

}
