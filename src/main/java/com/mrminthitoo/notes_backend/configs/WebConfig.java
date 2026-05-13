package com.mrminthitoo.notes_backend.configs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${image.root-dir}")
    private String uploadDir;

    private static final String userDir = System.getProperty("user.home") + "\\Pictures\\";

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        String path = userDir + uploadDir + "\\";

        log.info("image dir {}", path);

        registry.addResourceHandler("/images/**")
                .addResourceLocations("file:///" + path);
    }

}
