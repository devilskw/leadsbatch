package br.com.kazuo.leadsbatch.app.dataprovider.feign.oauth2.dto;

import br.com.kazuo.leadsbatch.app.config.properties.PropOauth2Req;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TokenReqBody {

    public TokenReqBody(PropOauth2Req properties) {
        this.clientId = properties.getClientId();
        this.clientSecret = properties.getClientSecret();
    }

    @JsonProperty("grant_type")
    @SerializedName("grant_type")
    private String grantType = "client_credentials";

    @JsonProperty("client_id")
    @SerializedName("client_id")
    private String clientId;

    @JsonProperty("client_secret")
    @SerializedName("client_secret")
    private String clientSecret;
}
