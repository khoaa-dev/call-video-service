package com.intern.callvideoservice.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


@Configuration
@EnableWebMvc
class WebConfig : WebMvcConfigurer {
    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:3000", "http://localhost:8080", "https://evtutors.herokuapp.com/")
            .allowCredentials(true)
            .allowedHeaders("*")
            .allowedMethods("HEAD","GET","POST","PUT","DELETE","PATCH")
    }
}