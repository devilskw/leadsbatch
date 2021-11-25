package br.com.kazuo.leadsbatch.app.dataprovider.feign.leads;

import br.com.kazuo.leadsbatch.app.dataprovider.feign.leads.dto.req.LeadsRequestDto;
import br.com.kazuo.leadsbatch.app.dataprovider.feign.leads.dto.resp.JsonRespBody;
import br.com.kazuo.leadsbatch.app.dataprovider.feign.oauth2.dto.TokenReqBody;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "tokenRequest", url = "${leads.host}")
public interface LeadsRequest {
    @RequestMapping(method = RequestMethod.GET, value = "${leads.path}", produces = "application/www-url-form-encoded", consumes = "application/json")
    JsonRespBody requestLeadsPeriod(@RequestParam LeadsRequestDto params, @RequestHeader("Authorization") String token, @RequestHeader("api-id") String apiId);
}

