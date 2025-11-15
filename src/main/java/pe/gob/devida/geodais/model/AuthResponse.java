package pe.gob.devida.geodais.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthResponse {
        
    @JsonProperty("Operacion")
    private Integer operation;
    
    @JsonProperty("Autenticado")
    private Boolean isAuthenticated; 
    
    @JsonProperty("Token")
    private String token; 
    
    @JsonProperty("Mensaje")
    private String message;
    
    @JsonProperty("NombreCompleto")
    private String fullName;
    
    @JsonProperty("COD_PERSONA") 
    private String personCode;
    
    public AuthResponse() {}

    // --- Getters y Setters ---

    public Integer getOperation() { return operation; }
    public void setOperation(Integer operation) { this.operation = operation; }

    public Boolean getIsAuthenticated() { return isAuthenticated; }
    public void setIsAuthenticated(Boolean isAuthenticated) { this.isAuthenticated = isAuthenticated; }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getPersonCode() { return personCode; }
    public void setPersonCode(String personCode) { this.personCode = personCode; }
}