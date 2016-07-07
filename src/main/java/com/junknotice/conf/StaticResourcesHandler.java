package com.junknotice.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by philu on 5/29/2016.
 */
@Configuration
public class StaticResourcesHandler extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/styles/**").addResourceLocations("lovediary/dist/styles/");
        registry.addResourceHandler("/fonts/**").addResourceLocations("lovediary/dist/fonts/");
        registry.addResourceHandler("/images/**").addResourceLocations("lovediary/app/images/");
        registry.addResourceHandler("/lib/**").addResourceLocations("lovediary/dist/lib/");
        registry.addResourceHandler("/scripts/**").addResourceLocations("lovediary/dist/scripts/");
        registry.addResourceHandler("/views/**").addResourceLocations("lovediary/dist/views/");
        registry.addResourceHandler("/assets/**").addResourceLocations("lovediary/dist/assets/");
        registry.addResourceHandler("/bower_components/**").addResourceLocations("lovediary/dist/bower_components/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("lovediary/dist/views/index.html");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
}
