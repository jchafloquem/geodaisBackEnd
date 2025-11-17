package pe.gob.devida.geodais.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WebConfig {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}