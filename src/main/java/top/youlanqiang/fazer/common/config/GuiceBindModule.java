package top.youlanqiang.fazer.common.config;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;
import org.mybatis.spring.mapper.MapperScannerConfigurer;

public class GuiceBindModule implements Module {


    @Override
    public void configure(Binder binder) {

    }

    /**
     * guice直接绑定一个实例
     */
    @Provides
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }

    @Provides
    public MybatisSqlSessionFactoryBean sqlSessionFactory(){
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        return bean;
    }


    @Provides
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        return configurer;
    }
}
