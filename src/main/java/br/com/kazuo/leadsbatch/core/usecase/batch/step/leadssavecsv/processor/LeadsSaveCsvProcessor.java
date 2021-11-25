package br.com.kazuo.leadsbatch.core.usecase.batch.step.leadssavecsv.processor;

import br.com.kazuo.leadsbatch.app.dataprovider.csv.dto.CsvLead;
import br.com.kazuo.leadsbatch.core.domain.leads.Leads;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LeadsSaveCsvProcessor implements ItemProcessor<Leads, CsvLead> {

    @Override
    public CsvLead process(Leads leads) throws Exception {
        log.info("Preparing to save lead {} to CSV ", leads == null ? "null" : leads.getCodLead());
        return new CsvLead(leads);
    }
}