package br.com.kazuo.leadsbatch.app.dataprovider.feign.oauth2.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Token {
    @JsonIgnore
    public static final String BEARERTOKEN = "Bearer";

    @JsonProperty("access_token")
    @SerializedName("access_token")
    @Setter(AccessLevel.NONE)
    private String token;

    @JsonProperty("token_type")
    @SerializedName("token_type")
    private String tokenType;

    @JsonProperty("expires_in")
    @SerializedName("expires_in")
    private Integer expiresIn;

    @JsonIgnore
    private Date dhToken;

    public void setToken(String token) {
        this.token = token;
        this.dhToken = new Date();
    }

    public String getBearerToken() {
        return BEARERTOKEN.concat(" ").concat(String.valueOf(this.token));
    }

    public Boolean needToRenew() {
        return this.token == null || this.dhToken == null || new Date().toInstant().isAfter(dhToken.toInstant().plusSeconds(300));
    }
}
