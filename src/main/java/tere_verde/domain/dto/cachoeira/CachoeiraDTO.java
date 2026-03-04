package tere_verde.domain.dto.cachoeira;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import tere_verde.domain.entity.cachoeira.Cachoeira;
import tere_verde.domain.entity.cachoeira.DificuldadeAcesso;

public record CachoeiraDTO(
    Long id,
    @NotBlank(message = "O nome é obrigatório")
    String nome,
    @NotNull(message = "A dificuldade de acesso é obrigatória")
    DificuldadeAcesso dificuldadeAcesso,
    String alturaQueda,
    @NotBlank(message = "A descrição é obrigatória")
    String descricao,
    @NotBlank(message = "O local é obrigatório")
    String local,
    @NotNull(message = "A informação sobre possuir piscina é obrigatória")
    Boolean possuiPiscina,
    @NotNull(message = "A informação sobre destaque é obrigatória")
    Boolean destaque,
    @NotNull(message = "A lista de imagens é obrigatória")
    List<String> imagens

) {
    public Cachoeira toEntity() {
        Cachoeira cachoeira = new Cachoeira();
        cachoeira.setId(this.id);
        cachoeira.setNome(this.nome);
        cachoeira.setDificuldadeAcesso(this.dificuldadeAcesso);
        cachoeira.setAlturaQueda(this.alturaQueda);
        cachoeira.setDescricao(this.descricao);
        cachoeira.setPossuiPiscina(this.possuiPiscina);
        cachoeira.setDestaque(this.destaque);
        cachoeira.setLocal(this.local);
        cachoeira.setImagens(this.imagens);
        return cachoeira;
    }

    public static CachoeiraDTO toDTO(Cachoeira cachoeira) {
        return new CachoeiraDTO(
            cachoeira.getId(),
            cachoeira.getNome(),
            cachoeira.getDificuldadeAcesso(),
            cachoeira.getAlturaQueda(),
            cachoeira.getDescricao(),
            cachoeira.getLocal(),
            cachoeira.getPossuiPiscina(),
            cachoeira.getDestaque(),
            cachoeira.getImagens()
        );
    }
}
