package br.com.kazuo.leadsbatch.app.dataprovider.feign.leads.dto.resp;

import br.com.kazuo.leadsbatch.core.domain.leads.Leads;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonRespBody {
    private List<Leads> leads = new ArrayList<>();
    @JsonProperty("total_elements")
    @SerializedName("total_elements")
    private Integer totalElements = 0;
}
