package tere_verde.controler;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import tere_verde.domain.dto.cachoeira.CachoeiraDTO;
import tere_verde.domain.entity.cachoeira.Cachoeira;
import tere_verde.repository.CachoeiraRepository;

@RestController
@RequestMapping("/cachoeira")
public class CachoeiraController {

    @Autowired
    private CachoeiraRepository cachoeiraRepository;

    @PostMapping
    public ResponseEntity<CachoeiraDTO> criarCachoeira(@RequestBody @Valid CachoeiraDTO cachoeira) {
        Cachoeira novaCachoeira = cachoeiraRepository.save(cachoeira.toEntity());
        CachoeiraDTO cachoeiraDTO = CachoeiraDTO.toDTO(novaCachoeira);
        return new ResponseEntity<>(cachoeiraDTO, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<CachoeiraDTO>> listarCachoeiras() {
        List<Cachoeira> cachoeiras = cachoeiraRepository.findAll();
        List<CachoeiraDTO> cachoeiraDTOs = cachoeiras.stream()
            .map(CachoeiraDTO::toDTO)
            .toList();
        return new ResponseEntity<>(cachoeiraDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CachoeiraDTO> buscarCachoeiraPorId(@PathVariable Long id) {
        Optional<Cachoeira> cachoeira = cachoeiraRepository.findById(id);
        return cachoeira.map(c -> ResponseEntity.ok(CachoeiraDTO.toDTO(c)))
                    .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CachoeiraDTO> atualizarCachoeira(@PathVariable Long id, @RequestBody @Valid CachoeiraDTO cachoeira) {
        
        if (!cachoeiraRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Cachoeira cachoeiraAtualizada = cachoeira.toEntity();
        cachoeiraAtualizada.setId(id);
        Cachoeira cachoeiraSalva = cachoeiraRepository.save(cachoeiraAtualizada);
        CachoeiraDTO cachoeiraDTO = CachoeiraDTO.toDTO(cachoeiraSalva);

        return ResponseEntity.ok(cachoeiraDTO);
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