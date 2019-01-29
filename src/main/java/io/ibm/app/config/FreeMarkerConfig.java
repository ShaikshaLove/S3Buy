package io.ibm.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;


@Configuration
public class FreeMarkerConfig {


    @Bean
    @Primary
    public FreeMarkerConfigurationFactoryBean fcb(){

        FreeMarkerConfigurationFactoryBean fcf=new FreeMarkerConfigurationFactoryBean();
        fcf.setTemplateLoaderPath("classpath:/templates");
        return fcf;

    }


}
