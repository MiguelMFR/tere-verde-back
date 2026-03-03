package tere_verde.domain.dto.biodiversidade;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import tere_verde.domain.entity.biodiversidade.Biodiversidade;
import tere_verde.domain.entity.biodiversidade.Classificacao;
import tere_verde.domain.entity.biodiversidade.StatusConservacao;

public record BiodiversidadeDTO(
    Long id,
    @NotBlank(message = "O nome é obrigatório")
    String nome,
    @NotBlank(message = "A espécie é obrigatória")
    String especie,
    @NotBlank(message = "A descrição é obrigatória")
    String descricao,
    @NotBlank(message = "O habitat é obrigatório")
    String habitat,
    @NotEmpty(message = "A lista de imagens não pode estar vazia")
    List<String> imagens,
    @NotNull(message = "A classificação é obrigatória")
    Classificacao classificacao,
    @NotNull(message = "O status de conservação é obrigatório")
    StatusConservacao statusConservacao,
    @NotNull(message = "O destaque é obrigatório")
    Boolean destaque
) {
    
    public Biodiversidade toEntity() {
        Biodiversidade biodiversidade = new Biodiversidade();
        biodiversidade.setId(this.id);
        biodiversidade.setNome(this.nome);
        biodiversidade.setEspecie(this.especie);
        biodiversidade.setDescricao(this.descricao);
        biodiversidade.setHabitat(this.habitat);
        biodiversidade.setImagens(this.imagens);
        biodiversidade.setClassificacao(this.classificacao);
        biodiversidade.setStatusConservacao(this.statusConservacao);
        biodiversidade.setDestaque(this.destaque);
        return biodiversidade;
    }

    public static BiodiversidadeDTO toDTO(Biodiversidade biodiversidade) {
        return new BiodiversidadeDTO(
            biodiversidade.getId(),
            biodiversidade.getNome(),
            biodiversidade.getEspecie(),
            biodiversidade.getDescricao(),
            biodiversidade.getHabitat(),
            biodiversidade.getImagens(),
            biodiversidade.getClassificacao(),
            biodiversidade.getStatusConservacao(),
            biodiversidade.getDestaque()
        );
    }


}
