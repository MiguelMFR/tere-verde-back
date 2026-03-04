package tere_verde.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tere_verde.domain.entity.usuario.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}
