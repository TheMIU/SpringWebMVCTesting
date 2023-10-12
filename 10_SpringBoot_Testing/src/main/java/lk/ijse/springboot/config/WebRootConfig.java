package lk.ijse.springboot.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(JPAConfig.class) // Import the JPA configuration class
@ComponentScan(basePackages = "lk.ijse.springboot.service")
public class WebRootConfig {
    public WebRootConfig() {
        System.out.println("WebRootConfig");
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
