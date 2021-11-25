package br.com.kazuo.leadsbatch.app.config.properties;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
@ConfigurationProperties(prefix = "csv")
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class PropCsv {
    @JsonProperty("date-format")
    @SerializedName("date-format")
    private String dtFormat = "yyyyMMddHHmmss";
    private String prefix = "Relatorio";

    @JsonIgnore
    private Date hoje = new Date();

    @JsonIgnore
    private SimpleDateFormat sdf = new SimpleDateFormat(dtFormat);
    public String getCsvFilename() throws ParseException {
        return prefix.concat("_").concat(sdf.format(hoje)).concat(".csv");
    }
}
