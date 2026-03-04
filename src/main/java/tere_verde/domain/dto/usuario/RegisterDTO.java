package tere_verde.domain.dto.usuario;

import jakarta.validation.constraints.Email;
import tere_verde.domain.entity.usuario.Usuario;

public record RegisterDTO(
    String nome,
    @Email
    String email,
    String senha
) {
    public Usuario toEntity(){
        Usuario usuario = new Usuario();
        usuario.setNome(this.nome);
        usuario.setEmail(this.email);
        usuario.setSenha(this.senha);
        return usuario;
    }

    public static RegisterDTO toDTO (Usuario usuario){
        return new RegisterDTO(
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getSenha());
    }
}
