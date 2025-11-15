package pe.gob.devida.geodais.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "T_SERVICIO_AUTH") 
@NoArgsConstructor
@AllArgsConstructor
public class ServiceAuthConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID") 
    private Long id;

    @Column(name = "CLAVE_CONFIGURACION", nullable = false) 
    private String claveConfiguracion; 

    @Column(name = "URL_SERVICIO", nullable = false) 
    private String serviceUrl;

    @Column(name = "ID_SISTEMA", nullable = false)
    private Integer systemId;

    public String getServiceUrl() {
        return serviceUrl;
    }

    public Integer getSystemId() {
        return systemId;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getClaveConfiguracion() { return claveConfiguracion; }
    public void setClaveConfiguracion(String claveConfiguracion) { this.claveConfiguracion = claveConfiguracion; }

    public void setServiceUrl(String serviceUrl) { this.serviceUrl = serviceUrl; }
    public void setSystemId(Integer systemId) { this.systemId = systemId; }
}