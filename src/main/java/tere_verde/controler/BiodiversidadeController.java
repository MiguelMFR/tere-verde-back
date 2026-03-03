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
import tere_verde.domain.dto.biodiversidade.BiodiversidadeDTO;
import tere_verde.domain.entity.biodiversidade.Biodiversidade;
import tere_verde.repository.BiodiversidadeRepository;


@RestController
@RequestMapping("/biodiversidade")
public class BiodiversidadeController { 

    @Autowired
    private BiodiversidadeRepository biodiversidadeRepository;

    @PostMapping
    public ResponseEntity<BiodiversidadeDTO> criarBiodiversidade(@RequestBody @Valid BiodiversidadeDTO biodiversidade) {
        Biodiversidade novaBiodiversidade = biodiversidadeRepository.save(biodiversidade.toEntity());
        BiodiversidadeDTO biodiversidadeDTO  = BiodiversidadeDTO.toDTO(novaBiodiversidade);
        return new ResponseEntity<>(biodiversidadeDTO, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<BiodiversidadeDTO>> listarBiodiversidades() {
        List<Biodiversidade> biodiversidades = biodiversidadeRepository.findAll();
        List<BiodiversidadeDTO> biodiversidadeDTOs = biodiversidades.stream()
            .map(BiodiversidadeDTO::toDTO)
            .toList();
        return new ResponseEntity<>(biodiversidadeDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BiodiversidadeDTO> buscarBiodiversidadePorId(@PathVariable Long id) {
        Optional<Biodiversidade> biodiversidade = biodiversidadeRepository.findById(id);
        return biodiversidade.map(bio -> ResponseEntity.ok(BiodiversidadeDTO.toDTO(bio)))
                    .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<BiodiversidadeDTO> atualizarBiodiversidade(@PathVariable Long id, @RequestBody @Valid BiodiversidadeDTO biodiversidade) {
        
        if (!biodiversidadeRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
    
        Biodiversidade biodiversidadeAtualizada = biodiversidade.toEntity();
        biodiversidadeAtualizada.setId(id);
        Biodiversidade biodiversidadeSalva = biodiversidadeRepository.save(biodiversidadeAtualizada);
        BiodiversidadeDTO biodiversidadeDTO = BiodiversidadeDTO.toDTO(biodiversidadeSalva);
        return ResponseEntity.ok(biodiversidadeDTO);
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