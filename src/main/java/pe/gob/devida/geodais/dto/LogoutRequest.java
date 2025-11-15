package pe.gob.devida.geodais.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogoutRequest {
	@NotBlank(message = "El campo 'login' es obligatorio para cerrar la sesión.")
    private String login;
}
