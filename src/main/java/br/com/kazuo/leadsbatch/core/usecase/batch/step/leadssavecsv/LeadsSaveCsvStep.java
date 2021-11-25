package br.com.kazuo.leadsbatch.core.usecase.batch.step.leadssavecsv;

import br.com.kazuo.leadsbatch.app.dataprovider.csv.dto.CsvLead;
import br.com.kazuo.leadsbatch.common.batch.BaseStep;
import br.com.kazuo.leadsbatch.core.domain.leads.Leads;
import br.com.kazuo.leadsbatch.core.usecase.batch.step.leadssavecsv.processor.LeadsSaveCsvProcessor;
import br.com.kazuo.leadsbatch.core.usecase.batch.step.leadssavecsv.reader.LeadsSaveCsvReader;
import br.com.kazuo.leadsbatch.core.usecase.batch.step.leadssavecsv.writer.LeadsSaveCsvWriter;
import org.springframework.batch.core.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class LeadsSaveCsvStep extends BaseStep {

    public static final String STEP_NAME = "stepLeadsSaveCsv";

    @Autowired
    private LeadsSaveCsvReader reader;

    @Autowired
    private LeadsSaveCsvProcessor processor;

    @Autowired
    private LeadsSaveCsvWriter writer;

    @Bean
    public Step stepLeadsSaveCsv() {
        return this.stepBuilderFactory.get(STEP_NAME)
                .listener(this.stepListener)
                .<Leads, CsvLead>chunk(this.propBatchConfig.getChunkLimit())
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }
}