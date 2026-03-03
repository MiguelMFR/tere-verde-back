package tere_verde.domain.entity.evento;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

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

    @JsonValue
    public String getNome() {
        return nome;
    }

    @JsonCreator
    public static TipoEvento fromString(String valor) {
        if (valor == null || valor.trim().isEmpty()) {
            return null;
        }
        
        String valorLimpo = valor.trim().toLowerCase();
        
        for (TipoEvento tipo : values()) {
            if (tipo.nome.equalsIgnoreCase(valorLimpo) || 
                tipo.name().equalsIgnoreCase(valorLimpo)) {
                return tipo;
            }
        }
        
        throw new IllegalArgumentException("Tipo de evento inválido: " + valor);
    }

    public static boolean isValid(String valor) {
        try {
            return fromString(valor) != null;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

}