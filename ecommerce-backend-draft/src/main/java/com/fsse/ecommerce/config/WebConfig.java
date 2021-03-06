package com.fsse.ecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                .addMapping("/**")
                .allowedOrigins(
                        "http://localhost:3000",
                        "http://front-end-ecommerce.s3-website-ap-southeast-1.amazonaws.com",
                        "https://www.markusho.tk"
                )
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE");
    }
}
