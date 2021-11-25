package br.com.kazuo.leadsbatch.common.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Period {
    private Date dtIni;
    private Date dtFim;

    public Period(Date dtIni, Date dtFim) {
        this.dtIni = dtIni;
        this.dtFim = dtFim;
    }
}