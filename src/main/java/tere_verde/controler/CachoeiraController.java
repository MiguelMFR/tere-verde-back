package tere_verde.controler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tere_verde.domain.cachoeira.Cachoeira;
import tere_verde.repository.CachoeiraRepository;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cachoeira")
public class CachoeiraController {

    @Autowired
    private CachoeiraRepository cachoeiraRepository;

    @PostMapping
    public ResponseEntity<Cachoeira> criarCachoeira(@RequestBody Cachoeira cachoeira) {
        Cachoeira novaCachoeira = cachoeiraRepository.save(cachoeira);
        return new ResponseEntity<>(novaCachoeira, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Cachoeira>> listarCachoeiras() {
        List<Cachoeira> cachoeiras = cachoeiraRepository.findAll();
        return new ResponseEntity<>(cachoeiras, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cachoeira> buscarCachoeiraPorId(@PathVariable Long id) {
        Optional<Cachoeira> cachoeira = cachoeiraRepository.findById(id);
        return cachoeira.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cachoeira> atualizarCachoeira(@PathVariable Long id, @RequestBody Cachoeira cachoeira) {

        if (!cachoeiraRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        cachoeira.setId(id);
        Cachoeira atualizado = cachoeiraRepository.save(cachoeira);

        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCachoeira(@PathVariable Long id) {
        if (!cachoeiraRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        cachoeiraRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}