package br.com.kazuo.leadsbatch.app.config.properties;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PropBaseUrl {
    private String host;
    private String path;
}
