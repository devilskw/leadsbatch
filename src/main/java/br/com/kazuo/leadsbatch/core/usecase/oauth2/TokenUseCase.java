package br.com.kazuo.leadsbatch.core.usecase.oauth2;

import br.com.kazuo.leadsbatch.app.config.cache.LeadsCacheControl;
import br.com.kazuo.leadsbatch.app.config.properties.PropOauth2Req;
import br.com.kazuo.leadsbatch.app.dataprovider.feign.oauth2.TokenRequest;
import br.com.kazuo.leadsbatch.app.dataprovider.feign.oauth2.dto.Token;
import br.com.kazuo.leadsbatch.app.dataprovider.feign.oauth2.dto.TokenReqBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TokenUseCase {
    
    @Autowired
    private TokenRequest tokenRequest;

    @Autowired
    private PropOauth2Req propOauth2Req;
    
    public Token getToken() {
        log.info("Getting token");
        if (LeadsCacheControl.getInstance().getToken() == null || LeadsCacheControl.getInstance().getToken().needToRenew()) {
            TokenReqBody tokenReqBody = new TokenReqBody(propOauth2Req);
            LeadsCacheControl.getInstance().setToken(this.tokenRequest.requestToken(tokenReqBody));
        }
        return LeadsCacheControl.getInstance().getToken();
    }
}
