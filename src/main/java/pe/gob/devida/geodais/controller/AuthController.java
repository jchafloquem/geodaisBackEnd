package pe.gob.devida.geodais.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.gob.devida.geodais.model.AuthRequest;
import pe.gob.devida.geodais.dto.LogoutRequest;
import pe.gob.devida.geodais.model.AuthResponse;
import pe.gob.devida.geodais.service.AuthService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/auth") 
public class AuthController {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        try {

            AuthResponse response = authService.authenticate(request);
            
            if (response != null && Boolean.TRUE.equals(response.getIsAuthenticated())) {
                return ResponseEntity.ok(response);
            } else {

                String message = (response != null && response.getMessage() != null) 
                                 ? response.getMessage() : "Credenciales inválidas proporcionadas.";
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(message);
            }
        } catch (SecurityException e) {

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error del servidor durante la autenticación: " + e.getMessage());
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestBody LogoutRequest request) {
        try {
        	
        	logger.info("Logout solicitado para el login: {}", request.getLogin());
            authService.logout(request.getLogin());
            return ResponseEntity.ok("Sesión cerrada correctamente.");
        } catch (Exception e) {
        	
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al cerrar la sesión: " + e.getMessage());
        }
    }
}