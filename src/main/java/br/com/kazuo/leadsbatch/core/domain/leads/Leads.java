package br.com.kazuo.leadsbatch.core.domain.leads;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Leads {
    @JsonProperty("codigo_informacao")
    @SerializedName("codigo_informacao")
    private String codInfo;

    @JsonProperty("codigo_lead")
    @SerializedName("codigo_lead")
    private String codLead;

    @JsonProperty("codigo_parceiro")
    @SerializedName("codigo_parceiro")
    private String codParceiro;

    private String nome;
    private String cpf;
    private String nascimento;

    @JsonProperty("codigo_status")
    @SerializedName("codigo_status")
    private Integer codStatus;

    @JsonProperty("codigo_tipo_bem")
    @SerializedName("codigo_tipo_bem")
    private Integer codTipoBem;

    @JsonProperty("valor_total_bem")
    @SerializedName("valor_total_bem")
    private Double vlTotalBem;

    @JsonProperty("valor_maximo_mensalidade_bem")
    @SerializedName("valor_maximo_mensalidade_bem")
    private Double vlMaxMensBem;

    @JsonProperty("quantidade_total_parcela")
    @SerializedName("quantidade_total_parcela")
    private Integer parcelas;

    @JsonProperty("data_hora_inclusao")
    @SerializedName("data_hora_inclusao")
    @JsonFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date dhInclusao;

    @JsonProperty("data_hora_manutencao")
    @SerializedName("data_hora_manutencao")
    @JsonFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date dhManutencao;

    @JsonProperty("texto_observacao")
    @SerializedName("texto_observacao")
    private String observacao;

    private List<LeadsEmail> email = new ArrayList<>();
    private List<LeadsTel> telefone = new ArrayList<>();
}
