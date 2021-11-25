package br.com.kazuo.leadsbatch.core.usecase.batch.step.leadsperiod;

import br.com.kazuo.leadsbatch.common.batch.BaseStep;
import br.com.kazuo.leadsbatch.core.usecase.batch.step.leadsperiod.tasklet.LeadsPeriodTasklet;
import org.springframework.batch.core.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LeadsPeriodStep extends BaseStep {

    public static final String STEP_NAME = "stepLeadsPeriod";

    @Autowired
    private LeadsPeriodTasklet leadsPeriodTasklet;

    @Bean
    public Step stepLeadsPeriod() {
        return this.stepBuilderFactory.get(STEP_NAME)
                .listener(this.stepListener)
                .tasklet(this.leadsPeriodTasklet)
                .build();
    }
}
