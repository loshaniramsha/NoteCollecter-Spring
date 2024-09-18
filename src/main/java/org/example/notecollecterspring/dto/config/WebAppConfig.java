package org.example.notecollecterspring.dto.config;

import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "org.example.notecollecterspring.dto")
@EnableWebMvc
@MultipartConfig

public class WebAppConfig {
}
