package br.com.kazuo.leadsbatch.app.dataprovider.feign.oauth2;

import br.com.kazuo.leadsbatch.app.dataprovider.feign.oauth2.dto.Token;
import br.com.kazuo.leadsbatch.app.dataprovider.feign.oauth2.dto.TokenReqBody;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "tokenRequest", url = "${oauth2.host}")
public interface TokenRequest {
    @RequestMapping(method = RequestMethod.POST, value = "${oauth2.path}", produces = "application/www-url-form-encoded", consumes = "application/json")
    Token requestToken(@RequestBody TokenReqBody reqBody);
}
