package pe.gob.devida.geodais.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.gob.devida.geodais.model.UserSession;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserSessionRepository extends JpaRepository<UserSession, Long> {

    
    Optional<UserSession> findByLoginAndFechaHoraSalidaIsNull(String login);

	List<UserSession> findByFechaHoraSalidaIsNotNullOrderByFechaHoraIngresoDesc();

	
}