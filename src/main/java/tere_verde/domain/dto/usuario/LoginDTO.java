package tere_verde.domain.dto.usuario;

import jakarta.validation.constraints.Email;
import tere_verde.domain.entity.usuario.Usuario;

public record LoginDTO(
    @Email
    String email,
    String senha
) {
    public Usuario toEntity() {
        Usuario usuario = new Usuario();
        usuario.setEmail(this.email);
        usuario.setSenha(this.senha);
        return usuario;
    }

    public static LoginDTO toDTO(Usuario usuario) {
        return new LoginDTO(
            usuario.getEmail(),
            usuario.getSenha()
        );
    }
}