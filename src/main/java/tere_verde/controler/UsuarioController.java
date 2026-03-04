package tere_verde.controler;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tere_verde.domain.dto.usuario.LoginDTO;
import tere_verde.domain.dto.usuario.RegisterDTO;
import tere_verde.domain.entity.usuario.Usuario;
import tere_verde.repository.UsuarioRepository;

@RestController
@RequestMapping("/admin")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private BCryptPasswordEncoder encoder;
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(loginDTO.email());

        if (usuarioOpt.isEmpty()) {
            return ResponseEntity.status(401).body("Credenciais inválidas");
        }

        Usuario usuario = usuarioOpt.get();

        if (!encoder.matches(loginDTO.senha(), usuario.getSenha())) {
            return ResponseEntity.status(401).body("Credenciais inválidas");
        }
        return ResponseEntity.ok("Login bem-sucedido");
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDTO registerDTO) {

        if (usuarioRepository.findByEmail(registerDTO.email()).isPresent()) {
            return ResponseEntity.status(400).body("Email já cadastrado");
        }

        String senhaCriptografada = encoder.encode(registerDTO.senha());
        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(registerDTO.nome());
        novoUsuario.setEmail(registerDTO.email());
        novoUsuario.setSenha(senhaCriptografada);
        usuarioRepository.save(novoUsuario);

        return ResponseEntity.ok("Usuário registrado com sucesso");
    }

}