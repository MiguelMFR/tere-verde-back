package tere_verde.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tere_verde.domain.biodiversidade.Biodiversidade;

public interface BiodiversidadeRepository extends JpaRepository<Biodiversidade, Long> {

}
