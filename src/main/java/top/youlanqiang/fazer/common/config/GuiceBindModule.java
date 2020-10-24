package top.youlanqiang.fazer.common.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;

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
}
