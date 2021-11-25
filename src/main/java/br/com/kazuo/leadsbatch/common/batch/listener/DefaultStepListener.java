package br.com.kazuo.leadsbatch.common.batch.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepListener;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.util.Date;

@Configuration
@Slf4j
public class DefaultStepListener implements StepListener {

    private Date stepTimeControl;

    @BeforeStep
    public void beforeStepExec(StepExecution stepExec) {
        this.stepTimeControl = new Date();
        log.info("Iniciando a execução da Step {}", stepExec.getStepName());
    }

    @AfterStep
    public ExitStatus afterStepExec(StepExecution stepExec) {
        Date finishedStep = new Date();
        log.info("Fim da execução da Step {} com status {}! Iniciado em: {} e finalizado em {} com duração de {} segundos"
                , stepExec.getStepName()
                , stepExec.getExitStatus().getExitCode()
                , this.stepTimeControl
                , finishedStep
                , Duration.between(this.stepTimeControl.toInstant(), finishedStep.toInstant()).getSeconds()
        );
        return stepExec.getExitStatus();
    }
}
