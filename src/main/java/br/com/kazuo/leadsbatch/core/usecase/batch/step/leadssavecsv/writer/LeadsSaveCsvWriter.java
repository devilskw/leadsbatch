package br.com.kazuo.leadsbatch.core.usecase.batch.step.leadssavecsv.writer;

import br.com.kazuo.leadsbatch.app.config.properties.PropCsv;
import br.com.kazuo.leadsbatch.app.dataprovider.csv.dto.CsvLead;
import br.com.kazuo.leadsbatch.app.dataprovider.csv.mapper.LeadsCsvMapper;
import org.springframework.batch.item.file.FlatFileHeaderCallback;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Writer;

@Component
public class LeadsSaveCsvWriter extends FlatFileItemWriter<CsvLead> {

    @Autowired
    public LeadsSaveCsvWriter(PropCsv propCsv) throws Exception {
        setResource(new FileSystemResource(propCsv.getCsvFilename()));
        setLineAggregator(new LeadsCsvMapper().getLeadsCsvMapperAggergator());
        setAppendAllowed(true);
        setHeaderCallback(new FlatFileHeaderCallback() {
            @Override
            public void writeHeader(Writer writer) throws IOException {
                writer.write(new LeadsCsvMapper().getHeader());
            }
        });
    }

}

