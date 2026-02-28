package tere_verde.domain.cachoeira;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    private String descricao;
    private Boolean possuiPsicina;
    private Boolean destaque;

    @ElementCollection
    @CollectionTable(name = "cachoeira_imagens",
            joinColumns = @JoinColumn(name = "cachoeira_id"))
    @Column(name = "imagem")
    private List<String> imagens = new ArrayList<>();;

    public Cachoeira() {}

    public Cachoeira(String nome, DificuldadeAcesso dificuldadeAcesso, String alturaQueda, 
                     String descricao, Boolean possuiPsicina, Boolean destaque, ArrayList<String> imagens) {
        this.nome = nome;
        this.dificuldadeAcesso = dificuldadeAcesso;
        this.alturaQueda = alturaQueda;
        this.descricao = descricao;
        this.possuiPsicina = possuiPsicina;
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

    public Boolean getPossuiPsicina() {
        return possuiPsicina;
    }

    public void setPossuiPsicina(Boolean possuiPsicina) {
        this.possuiPsicina = possuiPsicina;
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

    public void setImagens(ArrayList<String> imagens) {
        this.imagens = imagens;
    }
}
