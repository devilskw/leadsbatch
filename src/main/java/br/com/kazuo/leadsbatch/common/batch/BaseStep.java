package br.com.kazuo.leadsbatch.common.batch;

import br.com.kazuo.leadsbatch.common.batch.listener.DefaultStepListener;
import br.com.kazuo.leadsbatch.app.config.properties.PropBatchConfig;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public abstract class BaseStep {
    @Autowired
    protected StepBuilderFactory stepBuilderFactory;
    @Autowired
    protected DefaultStepListener stepListener;
    @Autowired
    protected PropBatchConfig propBatchConfig;

    /**
     * Monte o plano de execução da Step neste método, lembrando de:
     * - Utilizar o stepBuilderFactory
     * - Adicionar o listener stepListener
     * - configurar o chunk limit (podendo usar as propriedades de propBatchConfig)
     * - implementar os métodos de read/process/write (de acordo com a necessidade)
     *
     * @return Step
     */
    public Step stepExecutionPlan() {
        return null;
    }
}
