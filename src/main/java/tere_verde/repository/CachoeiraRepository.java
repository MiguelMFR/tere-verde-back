package tere_verde.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tere_verde.domain.cachoeira.Cachoeira;

public interface CachoeiraRepository extends JpaRepository<Cachoeira, Long> {
    
}