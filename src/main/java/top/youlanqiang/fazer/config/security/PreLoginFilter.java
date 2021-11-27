package top.youlanqiang.fazer.config.security;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpMethod;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.web.filter.GenericFilterBean;
import top.youlanqiang.fazer.common.utils.ParameterRequestWrapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/** @author youlanqiang created in 2021/11/27 11:23 上午 预登陆控制器 */
public class PreLoginFilter extends GenericFilterBean {

  private static final String USERNAME_KEY = UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY;

  private static final String PASSWORD_KEY = UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY;

  private static final String LOGIN_TYPE_KEY = "login_type";

  private final RequestMatcher requestMatcher;

  private final ObjectMapper objectMapper;


  private JsonNode jsonNode;

  // 管理登陆处理器
  private final Map<LoginTypeEnum, LoginPostProcessor> processorMap = new HashMap<>();

  public PreLoginFilter(
      String loginProcessingUrl, Collection<LoginPostProcessor> loginPostProcessors, ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
    Assert.notNull(loginPostProcessors, "loginProcessUrl must not be null");
    requestMatcher = new AntPathRequestMatcher(loginProcessingUrl, HttpMethod.POST.name());
    processorMap.put(LoginTypeEnum.JSON, defaultProcessor());

    if (!CollectionUtils.isEmpty(loginPostProcessors)) {
      loginPostProcessors.forEach(item->processorMap.put(item.getLoginType(), item));
    }
  }


  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    if(request instanceof HttpServletRequest){
      ParameterRequestWrapper wrapper = new ParameterRequestWrapper((HttpServletRequest) request);

    }



  }

  private LoginTypeEnum getType(ServletRequest request){
    String loginType = request.getParameter(LOGIN_TYPE_KEY);
    if(loginType == null){
      try{
        load(request);
        loginType = jsonNode.get(LOGIN_TYPE_KEY).asText();
      }catch (IOException e){
        //如果读取不到request body的值则默认是form表单提交
        return LoginTypeEnum.FORM;
      }
    }
    return LoginTypeEnum.valueOf(loginType);
  }

  private void load(ServletRequest request) throws IOException{
    if(jsonNode == null){
      jsonNode =  objectMapper.readTree(request.getInputStream());
    }
  }

  /**
   * 默认的登陆处理器
   *
   * @return processor
   */
  private LoginPostProcessor defaultProcessor() {
    return new LoginPostProcessor() {
      JsonNode jsonNode;

      @Override
      public LoginTypeEnum getLoginType() {
        return LoginTypeEnum.JSON;
      }

      @Override
      public String obtainUsername(ServletRequest request)  {
//        String json = StreamUtils.copyToString(request.getInputStream(), StandardCharsets.UTF_8);
        try{
          loadJson(request);
          return jsonNode.get(USERNAME_KEY).asText();
        }catch (IOException e){
          throw new RuntimeException("can not read request input steam");
        }
      }

      @Override
      public String obtainPassword(ServletRequest request) {
        try{
          loadJson(request);
          return jsonNode.get(PASSWORD_KEY).asText();
        }catch (IOException e){
          throw new RuntimeException("can not read request input steam");
        }
      }

      private void loadJson(ServletRequest request) throws IOException{
        if(jsonNode == null){
          jsonNode =  objectMapper.readTree(request.getInputStream());
        }
      }
    };
  }
}
