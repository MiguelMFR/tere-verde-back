package tere_verde.domain.dto.usuario;

import jakarta.validation.constraints.Email;

public record RegisterDTO(
    String nome,
    @Email
    String email,
    String senha
) {

}
