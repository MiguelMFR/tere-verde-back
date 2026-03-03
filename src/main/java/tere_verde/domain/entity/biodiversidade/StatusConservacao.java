package tere_verde.domain.biodiversidade;

public enum StatusConservacao {
    VULNERAVEL("vulneravel"),
    POUCO_PREOCUPANTE("pouco_preocupante"),
    EM_PERIGO("em_perigo"),
    CRITICA( "critica");

    private final String nome;

    StatusConservacao(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

}
