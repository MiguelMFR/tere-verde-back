package tere_verde.domain.trilha;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Trilha")
@Table(name = "trilhas")
public class Trilha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private String distancia; 
    private String duracao; 
    
    @Enumerated(EnumType.STRING)
    private Dificuldade dificuldade; 
    
    private String altitude;
    private Boolean destaque;

    @ElementCollection
    @CollectionTable(name = "trilha_imagens",
            joinColumns = @JoinColumn(name = "trilha_id"))
    @Column(name = "imagem")
    private List<String> imagens = new ArrayList<>();

    public Trilha() {}

    public Trilha(String nome, String descricao, String distancia, String duracao,
                  Dificuldade dificuldade, String altitude, Boolean destaque, List<String> imagens) {
        this.nome = nome;
        this.descricao = descricao;
        this.distancia = distancia;
        this.duracao = duracao;
        this.dificuldade = dificuldade;
        this.altitude = altitude;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDistancia() {
        return distancia;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public Dificuldade getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(Dificuldade dificuldade) {
        this.dificuldade = dificuldade;
    }

    public String getAltitude() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude;
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
}
