package tere_verde.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tere_verde.domain.entity.evento.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {
    
}