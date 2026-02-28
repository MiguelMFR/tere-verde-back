package tere_verde.domain.biodiversidade;

public enum Classificacao {
    AVE("ave"),
    MAMIFERO("mamifero"),
    PLANTA("planta");

    private final String nome;

    Classificacao(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }


}
