package br.com.kazuo.leadsbatch.app.config.properties;

import br.com.kazuo.leadsbatch.common.utils.LeadsDateUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Configuration
@ConfigurationProperties(prefix = "leads")
@JsonIgnoreProperties(ignoreUnknown = true)
public class PropLeadsReq extends PropBaseUrl {
    private String apiId;
    private String dtIni;
    private String dtFim;

    @JsonIgnore
    public static final Integer PERIOD_LIMIT_DAYS = 30;
    @JsonIgnore
    public static final Integer PAGE_SIZE_LIMIT = 15;
    @JsonIgnore
    public static final Integer PAGE_INDEX_INITIAL = 1;

    @JsonIgnore
    private SimpleDateFormat sdf = new SimpleDateFormat(LeadsDateUtils.STR_REQUEST_PARAM_DATE_FORMAT);
    @JsonIgnore
    @Autowired
    private LeadsDateUtils dateUtils;
    public Date getDtIniAsDate() throws ParseException {
        return dateUtils.adjustHourDate(sdf.parse(dtIni));
    }
    public Date getDtFimAsDate() throws ParseException {
        return dateUtils.adjustHourDate(sdf.parse(dtFim));
    }
}
