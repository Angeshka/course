package com.kursach.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MVCConfig implements WebMvcConfigurer {
    @Value("C:\\Users\\lenovo\\IdeaProjects\\kursach\\src\\main\\resources\\css")
    private String uploadcss;
    @Value("C:\\Users\\lenovo\\IdeaProjects\\kursach\\src\\main\\resources\\img")
    private String uploadimg;
    @Value("${upload.js}")
    private String uploadjs;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {//обработчики для различных ресурсов, с пом (сдинамическая раздача)
        registry.addResourceHandler("/css/**").addResourceLocations("file:" + uploadcss + "/");
        registry.addResourceHandler("/img/**").addResourceLocations("file:" + uploadimg + "/");
        registry.addResourceHandler("/js/**").addResourceLocations("file:" + uploadjs + "/");

    }
}
