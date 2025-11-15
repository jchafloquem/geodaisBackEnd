package pe.gob.devida.geodais.service;

import org.springframework.stereotype.Service;
import pe.gob.devida.geodais.model.ReporteSesionesDTO;
import pe.gob.devida.geodais.model.UserSession;
import pe.gob.devida.geodais.repository.UserSessionRepository;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReporteService {

    private final UserSessionRepository userSessionRepository;

    public ReporteService(UserSessionRepository userSessionRepository) {
        this.userSessionRepository = userSessionRepository;
    }

    public List<ReporteSesionesDTO> generarReporteSesiones() {
        List<UserSession> sesionesCerradas = userSessionRepository.findByFechaHoraSalidaIsNotNullOrderByFechaHoraIngresoDesc();

        return sesionesCerradas.stream()
                .map(session -> {
                    ReporteSesionesDTO dto = new ReporteSesionesDTO(session);
                    
                    if (session.getFechaHoraSalida() != null) {
                        Duration duration = Duration.between(session.getFechaHoraIngreso(), session.getFechaHoraSalida());
                        dto.setDuracionSegundos(duration.getSeconds());
                        dto.setTiempoUsoFormato(formatoDuracion(duration));
                    } else {
                    
                        dto.setDuracionSegundos(0L);
                        dto.setTiempoUsoFormato("Sesión Activa/No Cerrada");
                    }
                    
                    dto.setUbicacionGeocodificada(geocodificar(session.getCoordenadaIngreso()));

                    return dto;
                })
                .collect(Collectors.toList());
    }

    private String formatoDuracion(Duration duration) {
        long seconds = duration.getSeconds();
        long hours = seconds / 3600;
        long minutes = (seconds % 3600) / 60;
        long remainingSeconds = seconds % 60;
        
        return String.format("%dh %dm %ds", hours, minutes, remainingSeconds);
    }

    private String geocodificar(String coordenada) {
        if (coordenada == null || coordenada.trim().isEmpty() || "No Registrada".equals(coordenada)) {
            return "No Registrada";
        }
        
        if (coordenada.contains("-12.0") && coordenada.contains("-77.0")) {
            return "Lima, Perú (Capital)";
        }
        if (coordenada.contains("-9.9") && coordenada.contains("-76.6")) {
            return "Huánuco, Perú";
        }
        if (coordenada.contains("-7.1") && coordenada.contains("-78.5")) {
            return "Cajamarca, Perú";
        }
        
        return "Coordenada: " + coordenada;
    }
}