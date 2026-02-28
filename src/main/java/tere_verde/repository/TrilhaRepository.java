package tere_verde.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tere_verde.domain.trilha.Trilha;

public interface TrilhaRepository extends JpaRepository<Trilha, Long> {
    
}