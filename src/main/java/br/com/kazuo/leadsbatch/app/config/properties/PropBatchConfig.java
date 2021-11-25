package br.com.kazuo.leadsbatch.app.config.properties;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "batch")
@JsonIgnoreProperties(ignoreUnknown = true)
public class PropBatchConfig {
    private Integer qtdeTasks;

    @JsonIgnore
    private Integer chunkLimit = 250;

    @JsonIgnore
    private Integer pageSize = 20;
}
