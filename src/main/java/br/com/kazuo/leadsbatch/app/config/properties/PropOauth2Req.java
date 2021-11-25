package br.com.kazuo.leadsbatch.app.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "oauth2")
public class PropOauth2Req extends PropBaseUrl {
        private String clientId;
        private String clientSecret;
}
