package net.bradproctor.ngspringplate.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        boolean devMode = System.getProperty("devMode") != null && System.getProperty("devMode").equals("Y");

        if (devMode) {
            registry.addResourceHandler("/app/**").addResourceLocations("/app/");
        } else {
            registry.addResourceHandler("/app/**").addResourceLocations("/build/");
        }
    }

}