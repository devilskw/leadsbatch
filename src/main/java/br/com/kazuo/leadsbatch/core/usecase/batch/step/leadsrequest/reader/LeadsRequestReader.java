package br.com.kazuo.leadsbatch.core.usecase.batch.step.leadsrequest.reader;

import br.com.kazuo.leadsbatch.app.config.cache.LeadsCacheControl;
import br.com.kazuo.leadsbatch.core.usecase.leads.dto.LeadControlPeriod;
import io.micrometer.core.lang.Nullable;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

@Component
public class LeadsRequestReader implements ItemReader<LeadControlPeriod> {

    private Integer index;

    public LeadsRequestReader() {
        this.index = 0;
    }

    @Override
    @Nullable
    public LeadControlPeriod read() throws Exception {
        LeadControlPeriod periodpage =
                LeadsCacheControl.getInstance().getPeriodsPage().size() <= this.index ?
                        null : LeadsCacheControl.getInstance().getPeriodsPage().get(this.index);
        this.index++;
        return periodpage;
    }
}
