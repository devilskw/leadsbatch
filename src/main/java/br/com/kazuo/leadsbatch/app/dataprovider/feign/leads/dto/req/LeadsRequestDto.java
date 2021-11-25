package br.com.kazuo.leadsbatch.app.dataprovider.feign.leads.dto.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeadsRequestDto {
    private Integer page;
    @JsonProperty("data_inicial")
    @SerializedName("data_inicial")
    private Date dtini;
    @JsonProperty("data_final")
    @SerializedName("data_final")
    private Date dtFim;

    /*
    public String getUrlQueryParam() {
        SimpleDateFormat sdf = new SimpleDateFormat(LeadsDateUtils.STR_CSV_DATETIME_FORMAT);
        return new StringBuilder()
                .append("?page=")
                .append(String.valueOf(page))
                .append("&data_inicial=")
                .append(dtini == null ? "" : sdf.format(dtini))
                .append("&data_final=")
                .append(dtFim == null ? "" : sdf.format(dtFim))
                .toString();
    }
    */
}
