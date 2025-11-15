package pe.gob.devida.geodais.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.devida.geodais.model.ReporteSesionesDTO;
import pe.gob.devida.geodais.service.ReporteService;

import java.util.List;

@RestController
@RequestMapping("/api/reportes") 
public class ReporteController {

    private final ReporteService reporteService;

    public ReporteController(ReporteService reporteService) {
        this.reporteService = reporteService;
    }
    
    @GetMapping("/sesiones")
    public ResponseEntity<List<ReporteSesionesDTO>> getReporteSesiones() {
        List<ReporteSesionesDTO> reporte = reporteService.generarReporteSesiones();
        return ResponseEntity.ok(reporte);
    }
}
