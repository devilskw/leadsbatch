package br.com.kazuo.leadsbatch.core.usecase.batch.job;

import br.com.kazuo.leadsbatch.common.batch.listener.DefaultJobListener;
import br.com.kazuo.leadsbatch.core.usecase.batch.step.leadspreparetotalpagereq.LeadsPrepareTotalPageRequestStep;
import br.com.kazuo.leadsbatch.core.usecase.batch.step.leadsperiod.LeadsPeriodStep;
import br.com.kazuo.leadsbatch.core.usecase.batch.step.leadsrequest.LeadsRequestStep;
import br.com.kazuo.leadsbatch.core.usecase.batch.step.leadssavecsv.LeadsSaveCsvStep;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Qualifier
@Configuration
@EnableBatchProcessing
public class MainJob {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private DefaultJobListener jobListener;
    @Autowired
    private LeadsPeriodStep leadsPeriodStep;
    @Autowired
    private LeadsPrepareTotalPageRequestStep leadsPrepareTotalPageRequestStep;
    @Autowired
    private LeadsRequestStep leadsRequestStep;
    @Autowired
    private LeadsSaveCsvStep leadsSaveCsvStep;

    @Bean
    public Job mainJobPlanner() throws Exception {
        return this.jobBuilderFactory.get("Requisições de consulta de leads em lote")
                .listener(this.jobListener)
                .start(this.leadsPeriodStep.stepLeadsPeriod())
                .next(this.leadsPrepareTotalPageRequestStep.stepLeadsPrepareTotalPageRequest())
                .next(this.leadsRequestStep.stepLeadsRequest())
                .next(this.leadsSaveCsvStep.stepLeadsSaveCsv())
                .build();
    }

}
