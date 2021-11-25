package br.com.kazuo.leadsbatch.core.domain.leads;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LeadsTel {
    private String ddd;
    private String telefone;
}
