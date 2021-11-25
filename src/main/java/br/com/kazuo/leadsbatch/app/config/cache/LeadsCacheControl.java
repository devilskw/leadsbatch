package br.com.kazuo.leadsbatch.app.config.cache;

import br.com.kazuo.leadsbatch.app.dataprovider.feign.leads.dto.resp.JsonRespBody;
import br.com.kazuo.leadsbatch.app.dataprovider.feign.oauth2.dto.Token;
import br.com.kazuo.leadsbatch.core.domain.leads.Leads;
import br.com.kazuo.leadsbatch.core.usecase.leads.dto.LeadControlPeriod;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Data
public class LeadsCacheControl {

    @Getter(AccessLevel.PRIVATE)
    @Setter(AccessLevel.PRIVATE)
    private static LeadsCacheControl instance;

    @Getter(AccessLevel.PRIVATE)
    private List<LeadControlPeriod> periods;

    @Getter(AccessLevel.PRIVATE)
    private List<LeadControlPeriod> periodspage;

    @Getter(AccessLevel.PRIVATE)
    private List<Leads> leads;

    @Setter(AccessLevel.PRIVATE)
    private Token token;
    private Date dhToken;

    private LeadsCacheControl() {}

    // Singleton Pattern
    public static LeadsCacheControl getInstance() {
        if (instance == null) {
            instance = new LeadsCacheControl();
        }
        return instance;
    }

    public List<LeadControlPeriod> getPeriods() {
        if(periods == null) {
            periods = new ArrayList<>();
        }
        periods.sort(Comparator.comparing(LeadControlPeriod::getDtIni));
        return periods;
    }

    public void addPeriod(LeadControlPeriod period) {
        if(periods == null) {
            periods = new ArrayList<>();
        }
        periods.add(period);
    }

    public List<LeadControlPeriod> getPeriodsPage() {
        if(periodspage == null) {
            periodspage = new ArrayList<>();
        }
        periodspage.sort(Comparator.comparing(LeadControlPeriod::getDtIni).thenComparing(Comparator.comparing(LeadControlPeriod::getPage)));
        return periodspage;
    }

    public void addPeriodPage(LeadControlPeriod periodpage) {
        if(periodspage == null) {
            periodspage = new ArrayList<>();
        }
        periodspage.add(periodpage);
    }

    public List<Leads> getLeads() {
        if(leads == null) {
            leads = new ArrayList<>();
        }
        leads.sort(Comparator.comparing(Leads::getDhInclusao).thenComparing(Leads::getCodLead));
        return leads;
    }

    public void addLeads(Leads lead) {
        if(leads == null) {
            leads = new ArrayList<>();
        }
        leads.add(lead);
    }

    public void setToken(Token newToken) {
        token = newToken;
        dhToken = new Date();
    }

}
