package co.edu.uniquindio.proyecto.dto;
import co.edu.uniquindio.proyecto.seguridad.servicios.JwtService;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TokenDTO {

    @NotNull
    private String token;

    private String refreshToken;


}