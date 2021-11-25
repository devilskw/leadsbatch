package br.com.kazuo.leadsbatch.core.domain.leads;

import lombok.Getter;

import java.util.Arrays;

public enum StatusTipoBem {
    DESCONHECIDO(-99, "Status desconhecido"),
    STATUSBEM1(1, "Status Bem 1"),
    STATUSBEM2(2, "Status Bem 2"),
    STATUSBEM3(3, "Status Bem 3"),
    STATUSBEM4(4, "Status Bem 4"),
    STATUSBEM5(5, "Status Bem 5");

    @Getter
    private Integer value;
    @Getter
    private String description;

    StatusTipoBem(Integer value, String description) {
        this.value = value;
        this.description = description;
    }

    public static StatusTipoBem getByValue(Integer value) {
        if (value == null) {
            return StatusTipoBem.DESCONHECIDO;
        }
        return Arrays.stream(StatusTipoBem.values()).filter(s -> s.value == value).findFirst().orElse(StatusTipoBem.DESCONHECIDO);
    }
}
