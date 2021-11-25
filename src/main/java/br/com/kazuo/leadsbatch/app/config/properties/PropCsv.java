package br.com.kazuo.leadsbatch.app.config.properties;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Data
@Configuration
@ConfigurationProperties(prefix = "csv")
public class PropCsv {
    private String dtFormat;
    private String prefix = "Relatorio";
    private Boolean append = true;

    @JsonIgnore
    private Date hoje = new Date();
}
