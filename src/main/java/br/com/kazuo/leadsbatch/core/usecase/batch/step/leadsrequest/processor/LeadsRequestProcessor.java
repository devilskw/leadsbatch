package br.com.kazuo.leadsbatch.core.usecase.batch.step.leadsrequest.processor;

import br.com.kazuo.leadsbatch.app.config.properties.PropLeadsReq;
import br.com.kazuo.leadsbatch.app.dataprovider.feign.leads.LeadsRequest;
import br.com.kazuo.leadsbatch.app.dataprovider.feign.leads.dto.req.LeadsRequestDto;
import br.com.kazuo.leadsbatch.app.dataprovider.feign.leads.dto.resp.JsonRespBody;
import br.com.kazuo.leadsbatch.app.dataprovider.feign.oauth2.dto.Token;
import br.com.kazuo.leadsbatch.common.utils.LeadsPaginationUtils;
import br.com.kazuo.leadsbatch.core.usecase.leads.dto.LeadControlPeriod;
import br.com.kazuo.leadsbatch.core.usecase.oauth2.TokenUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Slf4j
@Component
public class LeadsRequestProcessor implements ItemProcessor<LeadControlPeriod, JsonRespBody> {

    @Autowired
    private TokenUseCase tokenUseCase;

    @Autowired
    private LeadsRequest leadsRequest;

    @Autowired
    private LeadsPaginationUtils leadsPaginationUtils;

    @Autowired
    private PropLeadsReq propLeadsReq;

    @Override
    public JsonRespBody process(LeadControlPeriod leadControlPeriod) throws Exception {
        log.info("Preparing to request page {} from period between {} and {}", leadControlPeriod.getPage(), leadControlPeriod.getDtIni(), leadControlPeriod.getDtFim());
        Token token = this.tokenUseCase.getToken();
        LeadsRequestDto requestDto = new LeadsRequestDto(leadControlPeriod.getPage(), leadControlPeriod.getDtIni(), leadControlPeriod.getDtFim());
        JsonRespBody respBody = leadsRequest.requestLeadsPeriod(requestDto, token.getToken(), propLeadsReq.getApiId());

        if (respBody == null) {
            respBody = new JsonRespBody();
            respBody.setLeads(new ArrayList<>());
        }

        return respBody;
    }
}
