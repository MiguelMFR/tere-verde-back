package tere_verde.domain.biodiversidade;

public enum Classificacao {
    AVE("ave"),
    MAMIFERO("mamifero"),
    FLORA("planta");

    private final String nome;

    Classificacao(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }


}
