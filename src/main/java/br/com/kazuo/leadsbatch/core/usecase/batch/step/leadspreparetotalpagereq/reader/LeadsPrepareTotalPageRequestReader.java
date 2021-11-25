package br.com.kazuo.leadsbatch.core.usecase.batch.step.leadspreparetotalpagereq.reader;

import br.com.kazuo.leadsbatch.app.config.cache.LeadsCacheControl;
import br.com.kazuo.leadsbatch.core.usecase.leads.dto.LeadControlPeriod;
import io.micrometer.core.lang.Nullable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LeadsPrepareTotalPageRequestReader implements  ItemReader<LeadControlPeriod> {

    private Integer index;

    public LeadsPrepareTotalPageRequestReader() {
        this.index = 0;
    }

    @Override
    @Nullable
    public LeadControlPeriod read() throws Exception {
        LeadControlPeriod period =
                LeadsCacheControl.getInstance().getPeriods().size() <= this.index ?
                        null : LeadsCacheControl.getInstance().getPeriods().get(this.index);
        this.index++;
        return period;
    }
}
