package br.com.kazuo.leadsbatch.core.usecase.batch.step.leadspreparetotalpagereq.writer;

import br.com.kazuo.leadsbatch.app.config.cache.LeadsCacheControl;
import br.com.kazuo.leadsbatch.app.dataprovider.feign.leads.dto.resp.JsonRespBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class LeadsPrepareTotalPageRequestWriter implements ItemWriter<JsonRespBody> {
    @Override
    public void write(List<? extends JsonRespBody> list) throws Exception {
        if (list != null && !list.isEmpty()) {
            for ( JsonRespBody body: list) {
                if (body.getLeads() != null && !body.getLeads().isEmpty()) {
                    LeadsCacheControl.getInstance().getLeads().addAll(body.getLeads());
                }
            }
        }
    }
}
