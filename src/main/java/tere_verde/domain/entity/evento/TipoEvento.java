package tere_verde.domain.evento;

public enum TipoEvento {
    CULTURAL("cultural"),
    ESPORTIVO("esportivo"),
    GASTRONOMICO("ecologico"),
    EDUCATIVO("educativo"),
    RELIGIOSO("religioso"),
    TURISTICO("turistico");

    private final String nome;

    TipoEvento(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

}