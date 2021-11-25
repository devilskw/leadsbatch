package br.com.kazuo.leadsbatch.core.usecase.batch.step.leadspreparetotalpagereq;

import br.com.kazuo.leadsbatch.app.dataprovider.feign.leads.dto.resp.JsonRespBody;
import br.com.kazuo.leadsbatch.common.batch.BaseStep;
import br.com.kazuo.leadsbatch.core.usecase.batch.step.leadspreparetotalpagereq.processor.LeadsPrepareTotalPageRequestProcessor;
import br.com.kazuo.leadsbatch.core.usecase.batch.step.leadspreparetotalpagereq.reader.LeadsPrepareTotalPageRequestReader;
import br.com.kazuo.leadsbatch.core.usecase.batch.step.leadspreparetotalpagereq.writer.LeadsPrepareTotalPageRequestWriter;
import br.com.kazuo.leadsbatch.core.usecase.leads.dto.LeadControlPeriod;
import org.springframework.batch.core.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class LeadsPrepareTotalPageRequestStep extends BaseStep {

    public static final String STEP_NAME = "stepLeadsPrepareTotalPageRequest";

    @Autowired
    private LeadsPrepareTotalPageRequestReader reader;

    @Autowired
    private LeadsPrepareTotalPageRequestProcessor processor;

    @Autowired
    private LeadsPrepareTotalPageRequestWriter writer;

    @Bean
    public Step stepLeadsPrepareTotalPageRequest() {
        return this.stepBuilderFactory.get(STEP_NAME)
                .listener(this.stepListener)
                .<LeadControlPeriod, JsonRespBody>chunk(this.propBatchConfig.getChunkLimit())
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }
}
