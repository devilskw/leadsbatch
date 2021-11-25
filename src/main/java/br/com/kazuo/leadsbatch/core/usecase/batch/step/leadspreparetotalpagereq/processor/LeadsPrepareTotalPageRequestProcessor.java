package br.com.kazuo.leadsbatch.core.usecase.batch.step.leadspreparetotalpagereq.processor;

import br.com.kazuo.leadsbatch.app.config.cache.LeadsCacheControl;
import br.com.kazuo.leadsbatch.common.utils.LeadsPaginationUtils;
import br.com.kazuo.leadsbatch.app.config.properties.PropLeadsReq;
import br.com.kazuo.leadsbatch.app.dataprovider.feign.leads.LeadsRequest;
import br.com.kazuo.leadsbatch.app.dataprovider.feign.leads.dto.req.LeadsRequestDto;
import br.com.kazuo.leadsbatch.app.dataprovider.feign.leads.dto.resp.JsonRespBody;
import br.com.kazuo.leadsbatch.app.dataprovider.feign.oauth2.dto.Token;
import br.com.kazuo.leadsbatch.core.usecase.leads.dto.LeadControlPeriod;
import br.com.kazuo.leadsbatch.core.usecase.oauth2.TokenUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LeadsPrepareTotalPageRequestProcessor implements ItemProcessor<LeadControlPeriod, JsonRespBody>{

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
        log.info("Preparing page 1 from period between {} and {}", leadControlPeriod.getDtIni(), leadControlPeriod.getDtFim());
        Token token = this.tokenUseCase.getToken();
        LeadsRequestDto requestDto = new LeadsRequestDto();
        JsonRespBody respBody = leadsRequest.requestLeadsPeriod(requestDto, token.getToken(), propLeadsReq.getApiId());

        leadControlPeriod.setPage(leadControlPeriod.getPage()+1);
        leadControlPeriod.setTotalElements(respBody.getTotalElements());
        Integer totalPage = leadsPaginationUtils.getTotalPages(PropLeadsReq.PAGE_INDEX_INITIAL, PropLeadsReq.PAGE_SIZE_LIMIT, respBody.getTotalElements());
        leadControlPeriod.setTotalPage(totalPage);

        // all pages per period (starting from next page)
        for(int i = PropLeadsReq.PAGE_INDEX_INITIAL +1 ; i <= totalPage; i++) {
            LeadControlPeriod pg = new LeadControlPeriod();
            pg.setDtIni(leadControlPeriod.getDtIni());
            pg.setDtFim(leadControlPeriod.getDtFim());
            pg.setPage(i);
            pg.setTotalPage(totalPage);
            pg.setTotalElements(respBody.getTotalElements());
            LeadsCacheControl.getInstance().addPeriodPage(pg);
        }
        return respBody;
    }
}
