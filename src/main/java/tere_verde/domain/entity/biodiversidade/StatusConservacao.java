package tere_verde.domain.entity.biodiversidade;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusConservacao {
    VULNERAVEL("vulneravel"),
    POUCO_PREOCUPANTE("pouco_preocupante"),
    EM_PERIGO("em_perigo"),
    CRITICA("critica");

    private final String nome;

    StatusConservacao(String nome) {
        this.nome = nome;
    }

    @JsonValue
    public String getNome() {
        return nome;
    }

    @JsonCreator
    public static StatusConservacao fromString(String valor) {
        if (valor == null || valor.trim().isEmpty()) {
            return null;
        }
        
        String valorLimpo = valor.trim().toLowerCase();
        
        for (StatusConservacao status : values()) {
            if (status.nome.equalsIgnoreCase(valorLimpo) || 
                status.name().equalsIgnoreCase(valorLimpo)) {
                return status;
            }
        }
        
        throw new IllegalArgumentException("Status de conservação inválido: " + valor);
    }

    public static boolean isValid(String valor) {
        try {
            return fromString(valor) != null;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

}
