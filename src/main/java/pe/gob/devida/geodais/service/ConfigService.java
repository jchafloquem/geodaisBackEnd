package pe.gob.devida.geodais.service;

import org.springframework.stereotype.Service;
import pe.gob.devida.geodais.model.ServiceAuthConfig;
import pe.gob.devida.geodais.repository.ServiceAuthConfigRepository;

@Service
public class ConfigService {

    private final ServiceAuthConfigRepository configRepository;

    public ConfigService(ServiceAuthConfigRepository configRepository) {
        this.configRepository = configRepository;
    }

    public ServiceAuthConfig getConfig(String claveConfiguracion) {

        return configRepository.findByClaveConfiguracion(claveConfiguracion)
                .orElseThrow(() -> new RuntimeException("No se encontró configuración para la clave: " + claveConfiguracion));
    }
}