package br.com.kazuo.leadsbatch.core.usecase.batch.step.leadsperiod.tasklet;

import br.com.kazuo.leadsbatch.common.utils.LeadsDateUtils;
import br.com.kazuo.leadsbatch.app.config.cache.LeadsCacheControl;
import br.com.kazuo.leadsbatch.app.config.properties.PropLeadsReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LeadsPeriodTasklet implements Tasklet {

    @Autowired
    private PropLeadsReq propLeadsReq;

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        LeadsCacheControl.getInstance().setPeriods(new LeadsDateUtils().listarPeriodos(propLeadsReq.getDtIniAsDate(), propLeadsReq.getDtFimAsDate(), PropLeadsReq.PERIOD_LIMIT_DAYS));
        log.info("Adicionados {} periodos, entre {} e {}", LeadsCacheControl.getInstance().getPeriods().size(), propLeadsReq.getDtIni(), propLeadsReq.getDtFim());
        return RepeatStatus.FINISHED;
    }
}
