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
    @JsonProperty("pagina")
    @SerializedName("pagina")
    private Integer page;

    @JsonProperty("data_inicio")
    @SerializedName("data_inicio")
    private Date dtini;

    @JsonProperty("data_fim")
    @SerializedName("data_fim")
    private Date dtFim;

    @JsonProperty("codigo_status")
    @SerializedName("codigo_status")
    private Integer codStatus = 0;

    @JsonProperty("codigo_vendedor")
    @SerializedName("codigo_vendedor")
    private String codVendedor = "0";

    @JsonProperty("codigo_parceiro_indicador")
    @SerializedName("codigo_parceiro_indicador")
    private String codParceiroIndicador;

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
