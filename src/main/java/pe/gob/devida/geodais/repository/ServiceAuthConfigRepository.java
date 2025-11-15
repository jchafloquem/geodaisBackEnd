package pe.gob.devida.geodais.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.gob.devida.geodais.model.ServiceAuthConfig;

import java.util.Optional;

@Repository
public interface ServiceAuthConfigRepository extends JpaRepository<ServiceAuthConfig, Long> {

    Optional<ServiceAuthConfig> findByClaveConfiguracion(String claveConfiguracion);
}