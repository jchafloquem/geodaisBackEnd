package pe.gob.devida.geodais.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        
        final String[] allowedOrigins = {
            "http://localhost:4200", 
            "https://sisqa.devida.gob.pe",
            "http://192.168.1.55:6019" 
        };
        
        registry.addMapping("/**") 
                .allowedOrigins(allowedOrigins) 
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") 
                .allowedHeaders("*") 
                .allowCredentials(true); 
    }
}