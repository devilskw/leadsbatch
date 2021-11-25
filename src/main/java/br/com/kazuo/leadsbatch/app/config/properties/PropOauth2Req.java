package br.com.kazuo.leadsbatch.app.config.properties;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "oauth2")
@Configuration
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PropOauth2Req extends PropBaseUrl {
        @JsonProperty("client-id")
        @SerializedName("client-id")
        private String clientId;
        @JsonProperty("client-secret")
        @SerializedName("client-secret")
        private String clientSecret;
}
