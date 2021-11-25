package br.com.kazuo.leadsbatch.core.domain.leads;

import lombok.Getter;

import java.util.Arrays;

public enum StatusLeads {
    DESCONHECIDO(-99, "Status desconhecido"),
    STATUS1(1, "Status 1"),
    STATUS2(2, "Status 2"),
    STATUS3(3, "Status 3"),
    STATUS4(4, "Status 4"),
    STATUS5(5, "Status 5"),
    STATUS6(6, "Status 6"),
    STATUS7(7, "Status 7"),
    STATUS8(8, "Status 8"),
    STATUS9(9, "Status 9"),
    STATUS10(10, "Status 10"),
    STATUS11(11, "Status 11"),
    STATUS12(12, "Status 12");

    @Getter
    private Integer value;
    @Getter
    private String description;

    StatusLeads(Integer value, String description) {
        this.value = value;
        this.description = description;
    }

    public static StatusLeads getByValue(Integer value) {
        if (value == null) {
            return StatusLeads.DESCONHECIDO;
        }
        return Arrays.stream(StatusLeads.values()).filter(s -> s.value == value).findFirst().orElse(StatusLeads.DESCONHECIDO);
    }
}
