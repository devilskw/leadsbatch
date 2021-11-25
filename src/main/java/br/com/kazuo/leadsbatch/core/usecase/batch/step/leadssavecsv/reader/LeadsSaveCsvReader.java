package br.com.kazuo.leadsbatch.core.usecase.batch.step.leadssavecsv.reader;

import br.com.kazuo.leadsbatch.app.config.cache.LeadsCacheControl;
import br.com.kazuo.leadsbatch.core.domain.leads.Leads;
import io.micrometer.core.lang.Nullable;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

@Component
public class LeadsSaveCsvReader implements ItemReader<Leads> {

    private Integer index;

    public LeadsSaveCsvReader() {
        this.index = 0;
    }

    @Override
    @Nullable
    public Leads read() throws Exception {
        Leads leads =
                LeadsCacheControl.getInstance().getLeads().size() <= this.index ?
                        null : LeadsCacheControl.getInstance().getLeads().get(this.index);
        this.index++;
        return leads;
    }
}