package tere_verde.domain.entity.trilha;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Dificuldade {
    FACIL("easy"),
    MODERADO("medium"),
    DIFICIL("hard");

    private final String nome;

    Dificuldade(String nome) {
        this.nome = nome;
    }

    @JsonValue
    public String getNome() {
        return nome;
    }

    @JsonCreator
    public static Dificuldade fromString(String valor) {
        if (valor == null || valor.trim().isEmpty()) {
            return null;
        }
        
        String valorLimpo = valor.trim().toLowerCase();
        
        for (Dificuldade dificuldade : values()) {
            if (dificuldade.nome.equalsIgnoreCase(valorLimpo) || 
                dificuldade.name().equalsIgnoreCase(valorLimpo)) {
                return dificuldade;
            }
        }
        
        throw new IllegalArgumentException("Dificuldade inválida: " + valor);
    }

    public static boolean isValid(String valor) {
        try {
            return fromString(valor) != null;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

}