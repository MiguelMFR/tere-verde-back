package tere_verde.domain.evento;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Evento")
@Table(name = "eventos")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;

    @ElementCollection
    @CollectionTable(name = "evento_imagens",
            joinColumns = @JoinColumn(name = "evento_id"))
    @Column(name = "imagem")
    private List<String> imagens = new ArrayList<>();;
    
    private Boolean destaque;
    private LocalDate data;
    private LocalDate dataFim;
    private String local;
    private Double preco;
    
    @Enumerated(EnumType.STRING)
    private TipoEvento tipo;

    public Evento() {}

    public Evento(String nome, String descricao, List<String> imagens, Boolean destaque, 
                  LocalDate data, LocalDate dataFim, String local, Double preco, TipoEvento tipo) {
        this.nome = nome;
        this.descricao = descricao;
        this.imagens = imagens;
        this.destaque = destaque;
        this.data = data;
        this.dataFim = dataFim;
        this.local = local;
        this.preco = preco;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<String> getImagens() {
        return imagens;
    }

    public void setImagens(List<String> imagens) {
        this.imagens = imagens;
    }

    public Boolean getDestaque() {
        return destaque;
    }

    public void setDestaque(Boolean destaque) {
        this.destaque = destaque;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public TipoEvento getTipo() {
        return tipo;
    }

    public void setTipo(TipoEvento tipo) {
        this.tipo = tipo;
    }
}
