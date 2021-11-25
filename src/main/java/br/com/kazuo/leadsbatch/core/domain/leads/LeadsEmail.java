package br.com.kazuo.leadsbatch.core.domain.leads;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LeadsEmail {
    private String email;
}
