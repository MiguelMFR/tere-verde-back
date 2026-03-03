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
import tere_verde.domain.dto.evento.EventoDTO;
import tere_verde.domain.entity.evento.Evento;
import tere_verde.repository.EventoRepository;

@RestController
@RequestMapping("/evento")
public class EventoController {

    @Autowired
    private EventoRepository eventoRepository;

    @PostMapping
    public ResponseEntity<EventoDTO> criarEvento(@RequestBody @Valid EventoDTO evento) {
        Evento novoEvento = eventoRepository.save(evento.toEntity());
        EventoDTO eventoDTO = EventoDTO.toDTO(novoEvento);
        return new ResponseEntity<>(eventoDTO, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<EventoDTO>> listarEventos() {
        List<Evento> eventos = eventoRepository.findAll();
        List<EventoDTO> eventosDTOs = eventos.stream()
            .map(EventoDTO::toDTO)
            .toList();
        return new ResponseEntity<>(eventosDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoDTO> buscarEventoPorId(@PathVariable Long id) {
        Optional<Evento> evento = eventoRepository.findById(id);
        return evento.map(e -> ResponseEntity.ok(EventoDTO.toDTO(e)))
                    .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventoDTO> atualizarEvento(@PathVariable Long id, @RequestBody @Valid EventoDTO evento) {
        
        if (!eventoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Evento eventoAtualizado = evento.toEntity();
        eventoAtualizado.setId(id);
        Evento eventoSalvo = eventoRepository.save(eventoAtualizado);
        EventoDTO eventoDTO = EventoDTO.toDTO(eventoSalvo);

        return ResponseEntity.ok(eventoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEvento(@PathVariable Long id) {
        if (!eventoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        eventoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}