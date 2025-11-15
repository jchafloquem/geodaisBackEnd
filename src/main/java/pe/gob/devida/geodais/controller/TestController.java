package pe.gob.devida.geodais.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.devida.geodais.model.ServiceAuthConfig;
import pe.gob.devida.geodais.service.ConfigService;

@RestController
@RequestMapping("/api/test")
public class TestController {

   
    private final ConfigService configService; 

    public TestController(ConfigService configService) {
        this.configService = configService;
    }

   
    @GetMapping("/config")
    public ResponseEntity<ServiceAuthConfig> testConfigConnection() {
        try {
   
            ServiceAuthConfig config = configService.getConfig("AUTENTICACION_SIGA");
            
   
            return ResponseEntity.ok(config);
            
        } catch (RuntimeException e) {
   
            System.err.println("Error al obtener la configuración: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}