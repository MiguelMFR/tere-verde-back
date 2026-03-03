package tere_verde.domain.entity.cachoeira;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum DificuldadeAcesso {
    FACIL("easy"),
    MODERADO("medium"),
    DIFICIL("hard");

    private final String nome;

    DificuldadeAcesso(String nome) {
        this.nome = nome;
    }

    @JsonValue
    public String getNome() {
        return nome;
    }

    @JsonCreator
    public static DificuldadeAcesso fromString(String valor) {
        if (valor == null || valor.trim().isEmpty()) {
            return null;
        }
        
        String valorLimpo = valor.trim().toLowerCase();
        
        for (DificuldadeAcesso dificuldade : values()) {
            if (dificuldade.nome.equalsIgnoreCase(valorLimpo) || 
                dificuldade.name().equalsIgnoreCase(valorLimpo)) {
                return dificuldade;
            }
        }
        
        throw new IllegalArgumentException("Dificuldade de acesso inválida: " + valor);
    }

    public static boolean isValid(String valor) {
        try {
            return fromString(valor) != null;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

}