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
import tere_verde.domain.dto.trilha.TrilhaDTO;
import tere_verde.domain.entity.trilha.Trilha;
import tere_verde.repository.TrilhaRepository;

@RestController
@RequestMapping("/trilha")
public class TrilhaController {

    @Autowired
    private TrilhaRepository trilhaRepository;

    @PostMapping
    public ResponseEntity<TrilhaDTO> criarTrilha(@RequestBody @Valid TrilhaDTO trilha) {
        Trilha novaTrilha = trilhaRepository.save(trilha.toEntity());
        TrilhaDTO trilhaDTO = TrilhaDTO.toDTO(novaTrilha);
        return new ResponseEntity<>(trilhaDTO, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<TrilhaDTO>> listarTrilhas() {
        List<Trilha> trilhas = trilhaRepository.findAll();
        List<TrilhaDTO> trilhaDTOs = trilhas.stream()
            .map(TrilhaDTO::toDTO)
            .toList();
        return new ResponseEntity<>(trilhaDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrilhaDTO> buscarTrilhaPorId(@PathVariable Long id) {
        Optional<Trilha> trilha = trilhaRepository.findById(id);
        return trilha.map(t -> ResponseEntity.ok(TrilhaDTO.toDTO(t)))
                    .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrilhaDTO> atualizarTrilha(@PathVariable Long id, @RequestBody @Valid TrilhaDTO trilha) {

        if (!trilhaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Trilha trilhaAtualizada = trilha.toEntity();
        trilhaAtualizada.setId(id);
        Trilha trilhaSalva = trilhaRepository.save(trilhaAtualizada);
        TrilhaDTO trilhaDTO = TrilhaDTO.toDTO(trilhaSalva);
        return ResponseEntity.ok(trilhaDTO);
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