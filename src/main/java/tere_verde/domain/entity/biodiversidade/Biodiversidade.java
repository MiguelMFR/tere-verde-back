package tere_verde.domain.biodiversidade;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Biodiversidade")
@Table(name = "biodiversidades")
public class Biodiversidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String especie;
    @Column(columnDefinition = "TEXT")
    private String descricao;
    private String habitat;

    @ElementCollection
    @CollectionTable(name = "biodiversidade_imagens",
            joinColumns = @JoinColumn(name = "biodiversidade_id"))
    @Column(name = "imagem", columnDefinition = "TEXT")
    @JsonProperty("imagem")
    private List<String> imagens = new ArrayList<>();;

    @Enumerated(EnumType.STRING)
    private Classificacao classificacao;
    
    @Enumerated(EnumType.STRING)
    private StatusConservacao statusConservacao;
    
    private Boolean destaque;

    public Biodiversidade() {

    }

    public Biodiversidade(String nome, String especie, String descricao, String habitat,
                          ArrayList<String> imagens, Classificacao classificacao,
                          StatusConservacao statusConservacao, Boolean destaque) {
        this.nome = nome;
        this.especie = especie;
        this.descricao = descricao;
        this.habitat = habitat;
        this.imagens = imagens;
        this.classificacao = classificacao;
        this.statusConservacao = statusConservacao;
        this.destaque = destaque;
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

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public List<String> getImagens() {
        return imagens;
    }

    public void setImagens(List<String> imagens) {
        this.imagens = imagens;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }

    public StatusConservacao getStatusConservacao() {
        return statusConservacao;
    }

    public void setStatusConservacao(StatusConservacao statusConservacao) {
        this.statusConservacao = statusConservacao;
    }

    public Boolean getDestaque() {
        return destaque;
    }

    public void setDestaque(Boolean destaque) {
        this.destaque = destaque;
    }
}
