package br.com.kazuo.leadsbatch.app.dataprovider.csv.dto;

import br.com.kazuo.leadsbatch.common.utils.LeadsDateUtils;
import br.com.kazuo.leadsbatch.core.domain.leads.Leads;
import br.com.kazuo.leadsbatch.core.domain.leads.StatusLeads;
import br.com.kazuo.leadsbatch.core.domain.leads.StatusTipoBem;
import lombok.Data;

import java.text.SimpleDateFormat;

@Data
public class CsvLead {

    public CsvLead(Leads lead) {
        SimpleDateFormat sdf = new SimpleDateFormat(LeadsDateUtils.STR_SYSOUT_DATETIME_FORMAT);
        this.dhInclusao = String.valueOf(sdf.format(lead.getDhInclusao()));
        this.dhManutencao = String.valueOf(sdf.format(lead.getDhManutencao()));
        this.valorMaxMensalidadeBem = String.valueOf(lead.getVlMaxMensBem());
        this.valorTotalBem = String.valueOf(lead.getVlTotalBem());
        this.codStatus = String.valueOf(lead.getCodStatus());
        this.descricaoStatus = String.valueOf(StatusLeads.getByValue(lead.getCodStatus()));
        this.parcelas = String.valueOf(lead.getParcelas());
        this.codInformacao = String.valueOf(lead.getCodInfo());
        this.codLead = String.valueOf(lead.getCodLead());
        this.codParceiro = String.valueOf(lead.getCodParceiro());
        this.codTipoBem = String.valueOf(lead.getCodTipoBem());
        this.descricaoTipoBem = String.valueOf(StatusTipoBem.getByValue(lead.getCodTipoBem()));
        this.cpf = String.valueOf(lead.getCpf());
        this.ddd1 = String.valueOf(lead.getTelefone().isEmpty() ? "" : lead.getTelefone().get(0).getDdd());
        this.ddd2 = String.valueOf(lead.getTelefone().isEmpty() || lead.getTelefone().size() < 2 ? "" : lead.getTelefone().get(1).getDdd());
        this.email = String.valueOf(lead.getEmail().isEmpty() ? "" : lead.getEmail().get(0).getEmail());
        this.nascimento = String.valueOf(lead.getNascimento());
        this.nome = String.valueOf(lead.getNome());
        this.observacao = String.valueOf(lead.getObservacao());
        this.telefone1 = String.valueOf(lead.getTelefone().isEmpty() ? "" : lead.getTelefone().get(0).getTelefone());
        this.telefone2 = String.valueOf(lead.getTelefone().isEmpty() || lead.getTelefone().size() < 2 ? "" : lead.getTelefone().get(1).getTelefone());
    }
    private String codInformacao;
    private String codLead;
    private String codParceiro;
    private String nome;
    private String cpf;
    private String nascimento;
    private String codStatus;
    private String descricaoStatus;
    private String codTipoBem;
    private String descricaoTipoBem;
    private String valorTotalBem;
    private String valorMaxMensalidadeBem;
    private String parcelas;
    private String dhInclusao;
    private String dhManutencao;
    private String observacao;
    private String email;
    private String ddd1;
    private String telefone1;
    private String ddd2;
    private String telefone2;
}
