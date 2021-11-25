package br.com.kazuo.leadsbatch.core.usecase.leads.dto;

import br.com.kazuo.leadsbatch.common.model.Period;
import br.com.kazuo.leadsbatch.app.config.properties.PropLeadsReq;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeadControlPeriod extends Period {
    private Integer page = PropLeadsReq.PAGE_INDEX_INITIAL;
    private Integer totalPage;
    private Integer totalElements;

    public LeadControlPeriod(Date dtini, Date dtfim ){
        super(dtini, dtfim);
    }
}
