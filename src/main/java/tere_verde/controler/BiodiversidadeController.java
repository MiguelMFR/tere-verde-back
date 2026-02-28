package tere_verde.controler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tere_verde.domain.biodiversidade.Biodiversidade;
import tere_verde.repository.BiodiversidadeRepository;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/biodiversidade")
public class BiodiversidadeController { 

    @Autowired
    private BiodiversidadeRepository biodiversidadeRepository;

    @PostMapping
    public ResponseEntity<Biodiversidade> criarBiodiversidade(@RequestBody Biodiversidade biodiversidade) {
        Biodiversidade novaBiodiversidade = biodiversidadeRepository.save(biodiversidade);
        return new ResponseEntity<>(novaBiodiversidade, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Biodiversidade>> listarBiodiversidades() {
        List<Biodiversidade> biodiversidades = biodiversidadeRepository.findAll();
        return new ResponseEntity<>(biodiversidades, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Biodiversidade> buscarBiodiversidadePorId(@PathVariable Long id) {
        Optional<Biodiversidade> biodiversidade = biodiversidadeRepository.findById(id);
        return biodiversidade.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Biodiversidade> atualizarBiodiversidade(@PathVariable Long id, @RequestBody Biodiversidade biodiversidade) {

        if (!biodiversidadeRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        biodiversidade.setId(id);
        Biodiversidade atualizado = biodiversidadeRepository.save(biodiversidade);

        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarBiodiversidade(@PathVariable Long id) {
        if (!biodiversidadeRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        biodiversidadeRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}