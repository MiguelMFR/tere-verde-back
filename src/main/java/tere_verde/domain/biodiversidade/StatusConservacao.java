package tere_verde.domain.biodiversidade;

public enum StatusConservacao {
    VULNERAVEL("vulneravel"),
    POUCO_PREOCUPANTE("pouco_preocupante"),
    QUASE_AMEACADO("quase_ameacado");

    private final String nome;

    StatusConservacao(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

}
