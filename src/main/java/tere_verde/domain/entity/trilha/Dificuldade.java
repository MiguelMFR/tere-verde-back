package tere_verde.domain.trilha;

public enum Dificuldade {
    FACIL("easy"),
    MODERADO("medium"),
    DIFICIL("hard");

    private final String nome;

    Dificuldade(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

}