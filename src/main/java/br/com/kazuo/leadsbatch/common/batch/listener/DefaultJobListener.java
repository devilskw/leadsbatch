package br.com.kazuo.leadsbatch.common.batch.listener;

import br.com.kazuo.leadsbatch.common.utils.LeadsDateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

@Configuration
@Slf4j
public class DefaultJobListener extends JobExecutionListenerSupport {

    private Date jobTimeControl;
    private SimpleDateFormat sdf = new SimpleDateFormat(LeadsDateUtils.STR_SYSOUT_DATETIME_FORMAT);

    @Override
    public void beforeJob(JobExecution jobExec) {
        this.jobTimeControl = new Date();
    }

    @Override
    public void afterJob(JobExecution jobExec) {
        Date finishedJob = new Date();
        if ((jobExec.getStatus() == BatchStatus.COMPLETED)) {
            log.info("Execução finalizada com sucesso! Iniciado em: {} e finalizado em {} com duração de {} segundos"
                    , this.jobTimeControl
                    , finishedJob
                    , Duration.between(this.jobTimeControl.toInstant(), finishedJob.toInstant()).getSeconds()
            );
        } else {
            log.error("Execução finalizada com ERRO! Tente novamente");
        }
    }

}
