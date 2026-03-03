package tere_verde.domain.entity.biodiversidade;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Classificacao {
    AVE("ave"),
    MAMIFERO("mamifero"),
    FLORA("planta"),
    REPTIL("reptil"),
    ANFIBIO("anfibio"),
    INSETO("inseto"),
    PEIXE("peixe"),
    OUTRO("outro");

    private final String nome;

    Classificacao(String nome) {
        this.nome = nome;
    }

    @JsonValue
    public String getNome() {
        return nome;
    }

    @JsonCreator
    public static Classificacao fromString(String valor) {
        if (valor == null || valor.trim().isEmpty()) {
            return null;
        }
        
        String valorLimpo = valor.trim().toLowerCase();
        
        for (Classificacao classificacao : values()) {
            if (classificacao.nome.equalsIgnoreCase(valorLimpo) || 
                classificacao.name().equalsIgnoreCase(valorLimpo)) {
                return classificacao;
            }
        }
        
        throw new IllegalArgumentException("Classificação inválida: " + valor);
    }

    public static boolean isValid(String valor) {
        try {
            return fromString(valor) != null;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

}
