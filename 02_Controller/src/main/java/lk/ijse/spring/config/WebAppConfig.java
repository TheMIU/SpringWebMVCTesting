package lk.ijse.spring.config;

import lk.ijse.spring.controller.CustomerController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = CustomerController.class)
public class WebAppConfig {
    public WebAppConfig() {
        System.out.println("WebAppConfig : Instantiated");
    }

    @Bean
    public ViewResolver viewResolver(){
        System.out.println("viewResolver");
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/webapp/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
