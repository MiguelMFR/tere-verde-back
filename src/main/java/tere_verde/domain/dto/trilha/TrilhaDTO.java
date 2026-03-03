package tere_verde.domain.dto.trilha;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import tere_verde.domain.entity.trilha.Dificuldade;
import tere_verde.domain.entity.trilha.Trilha;

public record TrilhaDTO(
    Long id,
    @NotBlank(message = "O nome da trilha é obrigatório")
    String nome,
    @NotBlank(message = "A descrição da trilha é obrigatória")
    String descricao,
    @NotBlank(message = "A distância da trilha é obrigatória")
    String distancia,
    @NotBlank(message = "A duração da trilha é obrigatória")
    String duracao,
    @NotNull(message = "A dificuldade da trilha é obrigatória")
    Dificuldade dificuldade,
    @NotBlank(message = "A altitude da trilha é obrigatória")
    String altitude,
    @NotNull(message = "A informação sobre destaque é obrigatória")
    Boolean destaque,
    @NotNull(message = "A lista de imagens é obrigatória")
    List<String> imagens
) {
    public Trilha toEntity() {
        Trilha trilha = new Trilha();
        trilha.setId(this.id);
        trilha.setNome(this.nome);
        trilha.setDescricao(this.descricao);
        trilha.setDistancia(this.distancia);
        trilha.setDuracao(this.duracao);
        trilha.setDificuldade(this.dificuldade);
        trilha.setAltitude(this.altitude);
        trilha.setDestaque(this.destaque);
        trilha.setImagens(this.imagens);
        return trilha;
    }

    public static TrilhaDTO toDTO(Trilha trilha) {
        return new TrilhaDTO(
            trilha.getId(),
            trilha.getNome(),
            trilha.getDescricao(),
            trilha.getDistancia(),
            trilha.getDuracao(),
            trilha.getDificuldade(),
            trilha.getAltitude(),
            trilha.getDestaque(),
            trilha.getImagens()
        );
    }
}
