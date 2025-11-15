package pe.gob.devida.geodais.model;

import java.time.LocalDateTime;

public class ReporteSesionesDTO {

    private Long id;
    private String login;
    private String nombreCompleto;
    private LocalDateTime fechaHoraIngreso;
    private LocalDateTime fechaHoraSalida;

    private String coordenadaIngreso; 
    private String ubicacionGeocodificada; 
    private String tiempoUsoFormato; 
    private Long duracionSegundos; 

    public ReporteSesionesDTO() {}
    
    public ReporteSesionesDTO(UserSession session) {
        this.id = session.getId();
        this.login = session.getLogin();
        this.nombreCompleto = session.getNombreCompleto();
        this.fechaHoraIngreso = session.getFechaHoraIngreso();
        this.fechaHoraSalida = session.getFechaHoraSalida();
        this.coordenadaIngreso = session.getCoordenadaIngreso();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

    public LocalDateTime getFechaHoraIngreso() { return fechaHoraIngreso; }
    public void setFechaHoraIngreso(LocalDateTime fechaHoraIngreso) { this.fechaHoraIngreso = fechaHoraIngreso; }

    public LocalDateTime getFechaHoraSalida() { return fechaHoraSalida; }
    public void setFechaHoraSalida(LocalDateTime fechaHoraSalida) { this.fechaHoraSalida = fechaHoraSalida; }

    public String getCoordenadaIngreso() { return coordenadaIngreso; }
    public void setCoordenadaIngreso(String coordenadaIngreso) { this.coordenadaIngreso = coordenadaIngreso; }

    public String getUbicacionGeocodificada() { return ubicacionGeocodificada; }
    public void setUbicacionGeocodificada(String ubicacionGeocodificada) { this.ubicacionGeocodificada = ubicacionGeocodificada; }

    public String getTiempoUsoFormato() { return tiempoUsoFormato; }
    public void setTiempoUsoFormato(String tiempoUsoFormato) { this.tiempoUsoFormato = tiempoUsoFormato; }

    public Long getDuracionSegundos() { return duracionSegundos; }
    public void setDuracionSegundos(Long duracionSegundos) { this.duracionSegundos = duracionSegundos; }
}