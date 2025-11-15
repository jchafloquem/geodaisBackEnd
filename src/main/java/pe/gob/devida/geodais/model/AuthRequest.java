package pe.gob.devida.geodais.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthRequest {
    
    @JsonProperty("LOGIN")
    private String login;

    
    private String clave; 
    
    @JsonProperty("id_sistema")
    private Integer idSistema; 
    

    @JsonProperty("coordenada_ingreso") 
    private String coordenadaIngreso; 

    public AuthRequest() {}

    // --- Getters y Setters ---

    public String getLogin() { 
        return login; 
    }

    public void setLogin(String login) { 
        this.login = login; 
    }

    public String getClave() { 
        return clave; 
    } 
    
    public void setClave(String clave) { 
        this.clave = clave; 
    }

    public Integer getIdSistema() { 
        return idSistema; 
    }
    
    public void setIdSistema(Integer idSistema) { 
    	this.idSistema = idSistema;
    }
    
    public String getCoordenadaIngreso() {
        return coordenadaIngreso;
    }

    public void setCoordenadaIngreso(String coordenadaIngreso) {
        this.coordenadaIngreso = coordenadaIngreso;
    }

}