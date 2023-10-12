package lk.ijse.springboot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"lk.ijse.springboot.controller", "lk.ijse.springboot.adviser"})
public class WebAppConfig {
    public WebAppConfig() {
        System.out.println("WebAppConfig");
    }
}
