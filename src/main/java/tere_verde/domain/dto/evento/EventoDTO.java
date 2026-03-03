package tere_verde.domain.dto.evento;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import tere_verde.domain.entity.evento.Evento;
import tere_verde.domain.entity.evento.TipoEvento;

public record EventoDTO(
    Long id, 
    @NotBlank(message = "O nome do evento é obrigatório")
    String nome,
    @NotBlank(message = "A descrição do evento é obrigatória")
    String descricao,
    @NotNull(message = "A lista de imagens do evento é obrigatória")
    List<String> imagens,
    @NotNull(message = "O destaque do evento é obrigatório")
    Boolean destaque,
    @NotBlank(message = "A data do evento é obrigatória")
    String data,
    @NotBlank(message = "A data de fim do evento é obrigatória")
    String dataFim,
    @NotBlank(message = "O local do evento é obrigatório")
    String local,
    @NotNull(message = "O preço do evento é obrigatório")
    Double preco,
    @NotNull(message = "O tipo do evento é obrigatório")
    TipoEvento tipo
    ) {

    public Evento toEntity() {
        if (this.tipo() != null) {
            TipoEvento.isValid(this.tipo.toString());
        }
        Evento evento = new Evento();
        evento.setId(this.id);
        evento.setNome(this.nome);
        evento.setDescricao(this.descricao);
        evento.setImagens(this.imagens);
        evento.setDestaque(this.destaque);
        evento.setData(java.time.LocalDate.parse(this.data));
        evento.setDataFim(java.time.LocalDate.parse(this.dataFim));
        evento.setLocal(this.local);
        evento.setPreco(this.preco);
        evento.setTipo(this.tipo);
        return evento;
    }

    public static EventoDTO toDTO(Evento evento) {
        return new EventoDTO(
            evento.getId(),
            evento.getNome(),
            evento.getDescricao(),
            evento.getImagens(),
            evento.getDestaque(),
            evento.getData().toString(),
            evento.getDataFim().toString(),
            evento.getLocal(),
            evento.getPreco(),
            evento.getTipo()
        );
    }
}
