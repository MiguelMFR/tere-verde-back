package tere_verde.controler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tere_verde.domain.trilha.Trilha;
import tere_verde.repository.TrilhaRepository;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trilha")
public class TrilhaController {

    @Autowired
    private TrilhaRepository trilhaRepository;

    @PostMapping
    public ResponseEntity<Trilha> criarTrilha(@RequestBody Trilha trilha) {
        Trilha novaTrilha = trilhaRepository.save(trilha);
        return new ResponseEntity<>(novaTrilha, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Trilha>> listarTrilhas() {
        List<Trilha> trilhas = trilhaRepository.findAll();
        return new ResponseEntity<>(trilhas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trilha> buscarTrilhaPorId(@PathVariable Long id) {
        Optional<Trilha> trilha = trilhaRepository.findById(id);
        return trilha.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trilha> atualizarTrilha(@PathVariable Long id, @RequestBody Trilha trilha) {

        if (!trilhaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        trilha.setId(id);
        Trilha atualizado = trilhaRepository.save(trilha);

        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTrilha(@PathVariable Long id) {
        if (!trilhaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        trilhaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}