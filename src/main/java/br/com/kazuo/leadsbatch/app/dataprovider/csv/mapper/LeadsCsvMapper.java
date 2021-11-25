package br.com.kazuo.leadsbatch.app.dataprovider.csv.mapper;

import br.com.kazuo.leadsbatch.app.dataprovider.csv.dto.CsvLead;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;

public class LeadsCsvMapper {

    public String[] getHeaderArr() {
        return new String[] {
                "codInformacao",
                "codLead",
                "codParceiro",
                "nome",
                "cpf",
                "nascimento",
                "codStatus",
                "descricaoStatus",
                "codTipoBem",
                "descricaoTipoBem",
                "valorTotalBem",
                "valorMaxMensalidadeBem",
                "parcelas",
                "dhInclusao",
                "dhManutencao",
                "observacao",
                "email",
                "ddd1",
                "telefone1",
                "ddd2",
                "telefone2"
        };
    }

    public String getHeader() {
        String header = "";
        for(String h: getHeaderArr()) {
            if (header.isEmpty()) {
                header += h;
            } else {
                header += ";" + h;
            }
        }
        return header;
    }

    public DelimitedLineAggregator<CsvLead> getLeadsCsvMapperAggergator() {
        BeanWrapperFieldExtractor<CsvLead> fieldExtractor = new BeanWrapperFieldExtractor<CsvLead>();
        fieldExtractor.setNames(getHeaderArr());
        DelimitedLineAggregator<CsvLead> leadsCsvMapperAggr = new DelimitedLineAggregator<CsvLead>();
        leadsCsvMapperAggr.setDelimiter(";");
        leadsCsvMapperAggr.setFieldExtractor(fieldExtractor);
        return leadsCsvMapperAggr;
    }
}
