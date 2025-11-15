package pe.gob.devida.geodais.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "T_USUARIO_SESION") 
public class UserSession {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID") 
    private Long id; 
    

    @Column(name = "LOGIN", nullable = false) 
    private String login; 

    @Column(name = "NOMBRE_COMPLETO") 
    private String nombreCompleto; 

    @Column(name = "COORDENADA_INGRESO") 
    private String coordenadaIngreso; 


    @Column(name = "FECHA_HORA_INGRESO", nullable = false) 
    private LocalDateTime fechaHoraIngreso; 


    @Column(name = "FECHA_HORA_SALIDA") 
    private LocalDateTime fechaHoraSalida; 

    public UserSession() {

        this.fechaHoraIngreso = LocalDateTime.now(); 

    }
    
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }
    
    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }
    
    public String getCoordenadaIngreso() { return coordenadaIngreso; }
    public void setCoordenadaIngreso(String coordenadaIngreso) { this.coordenadaIngreso = coordenadaIngreso; }
    
    public LocalDateTime getFechaHoraIngreso() { return fechaHoraIngreso; }
    public void setFechaHoraIngreso(LocalDateTime fechaHoraIngreso) { this.fechaHoraIngreso = fechaHoraIngreso; }
    
    public LocalDateTime getFechaHoraSalida() { return fechaHoraSalida; }
    public void setFechaHoraSalida(LocalDateTime fechaHoraSalida) { this.fechaHoraSalida = fechaHoraSalida; }

}