package tere_verde.domain.cachoeira;

public enum DificuldadeAcesso {
    FACIL("easy"),
    MODERADO("medium"),
    DIFICIL("hard");

    private final String nome;


    DificuldadeAcesso(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

}