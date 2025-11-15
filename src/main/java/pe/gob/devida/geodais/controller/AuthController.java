package pe.gob.devida.geodais.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.gob.devida.geodais.model.AuthRequest;
import pe.gob.devida.geodais.model.AuthResponse;
import pe.gob.devida.geodais.service.AuthService;

import java.util.Map;

@RestController
@RequestMapping("/api/auth") 
@CrossOrigin(origins = {"http://localhost:4200"}) 
public class AuthController {

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
    public ResponseEntity<String> logout(@RequestBody Map<String, String> request) {
        String login = request.get("login");
        
        if (login == null || login.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("El campo 'login' es requerido para el logout.");
        }

        try {

            authService.logout(login);
            return ResponseEntity.ok("Sesión cerrada correctamente.");
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno al intentar cerrar la sesión: " + e.getMessage());
        }
    }
}