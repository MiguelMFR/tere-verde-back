package tere_verde.domain.entity.cachoeira;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity(name = "Cachoeira")
@Table(name = "cachoeiras")
public class Cachoeira {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    
    @Enumerated(EnumType.STRING)
    private DificuldadeAcesso dificuldadeAcesso;
    
    private String alturaQueda;
    @Column(columnDefinition = "TEXT")
    private String descricao;
    private String local;

    private Boolean possuiPiscina;
    private Boolean destaque;

    @ElementCollection
    @CollectionTable(name = "cachoeira_imagens",
            joinColumns = @JoinColumn(name = "cachoeira_id"))
    @Column(name = "imagem", columnDefinition = "TEXT")
    @JsonProperty("imagem")
    private List<String> imagens = new ArrayList<>();;

    public Cachoeira() {}

    public Cachoeira(String nome, DificuldadeAcesso dificuldadeAcesso, String alturaQueda, 
                     String descricao, String local, Boolean possuiPiscina, Boolean destaque, ArrayList<String> imagens) {
        this.nome = nome;
        this.dificuldadeAcesso = dificuldadeAcesso;
        this.alturaQueda = alturaQueda;
        this.descricao = descricao;
        this.local = local;
        this.possuiPiscina = possuiPiscina;
        this.destaque = destaque;
        this.imagens = imagens;
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

    public DificuldadeAcesso getDificuldadeAcesso() {
        return dificuldadeAcesso;
    }

    public void setDificuldadeAcesso(DificuldadeAcesso dificuldadeAcesso) {
        this.dificuldadeAcesso = dificuldadeAcesso;
    }

    public Boolean getPossuiPiscina() {
        return possuiPiscina;
    }

    public void setPossuiPiscina(Boolean possuiPiscina) {
        this.possuiPiscina = possuiPiscina;
    }

    public String getAlturaQueda() {
        return alturaQueda;
    }

    public void setAlturaQueda(String alturaQueda) {
        this.alturaQueda = alturaQueda;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getDestaque() {
        return destaque;
    }

    public void setDestaque(Boolean destaque) {
        this.destaque = destaque;
    }

    public List<String> getImagens() {
        return imagens;
    }

    public void setImagens(List<String> imagens) {
        this.imagens = imagens;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
