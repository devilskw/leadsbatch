package br.com.kazuo.leadsbatch.core.usecase.batch.step.leadsrequest;

import br.com.kazuo.leadsbatch.app.dataprovider.feign.leads.dto.resp.JsonRespBody;
import br.com.kazuo.leadsbatch.common.batch.BaseStep;
import br.com.kazuo.leadsbatch.core.usecase.batch.step.leadsrequest.processor.LeadsRequestProcessor;
import br.com.kazuo.leadsbatch.core.usecase.batch.step.leadsrequest.reader.LeadsRequestReader;
import br.com.kazuo.leadsbatch.core.usecase.batch.step.leadsrequest.writer.LeadsRequestWriter;
import br.com.kazuo.leadsbatch.core.usecase.leads.dto.LeadControlPeriod;
import org.springframework.batch.core.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LeadsRequestStep extends BaseStep {

    public static final String STEP_NAME = "stepLeadsRequest";

    @Autowired
    private LeadsRequestReader reader;

    @Autowired
    private LeadsRequestProcessor processor;

    @Autowired
    private LeadsRequestWriter writer;

    @Bean
    public Step stepLeadsRequest() {
        return this.stepBuilderFactory.get(STEP_NAME)
                .listener(this.stepListener)
                .<LeadControlPeriod, JsonRespBody>chunk(this.propBatchConfig.getChunkLimit())
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

}