package br.com.kazuo.leadsbatch.common.utils;

import br.com.kazuo.leadsbatch.core.usecase.leads.dto.LeadControlPeriod;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Configuration
public class LeadsDateUtils {

    public static final String STR_SYSOUT_DATETIME_FORMAT = "dd/MM/yyyy HH:mm:ss";
    public static final String STR_FILE_DATETIME_FORMAT = "yyyyMMdd_HHmmss";
    public static final String STR_RESPONSEBODY_DATETIME_FORMAT = "MM/dd/yyyy HH:mm:ss";
    public static final String STR_CSV_DATETIME_FORMAT = "dd/MM/yyyy HH:mm:ss";
    public static final String STR_FILE_DATE_FORMAT = "yyyyMMdd";
    public static final String STR_REQUEST_PARAM_DATE_FORMAT = "dd/MM/yyyy";

    public List<LeadControlPeriod> listarPeriodos(Date dtini, Date dtfim, Integer daysInterval) {
        List<LeadControlPeriod> period = new ArrayList<>();
        Date tmpDtIni = adjustHourDate(dtini);
        Date tmpDtFim = addDays(tmpDtIni, daysInterval-1);

        if (tmpDtFim.after(dtfim)) {
            tmpDtFim = dtfim;
        }
        period.add(new LeadControlPeriod(tmpDtIni, tmpDtFim));
        while (tmpDtFim.before(dtfim)) {
            tmpDtIni = addDays(tmpDtFim, 1);
            tmpDtFim = addDays(tmpDtIni, daysInterval-1);
            if (tmpDtIni.after(dtfim)) {
                tmpDtIni = dtfim;
            }
            if (tmpDtFim.after(dtfim)) {
                tmpDtFim = dtfim;
            }
            period.add(new LeadControlPeriod(tmpDtIni, tmpDtFim));
        }
        return period;
    }

    public Date addDays(Date dt, Integer days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dt);
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }

    public Date adjustHourDate(Date dt) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dt);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR, 0);
        return calendar.getTime();
    }

    public String getCsvFilename(String prefix, String dtFormat, Date hoje) throws ParseException {
        if (dtFormat != null && !dtFormat.isBlank()){
            SimpleDateFormat sdf = new SimpleDateFormat(dtFormat);
            return prefix.concat("_").concat(sdf.format(hoje)).concat(".csv");
        }
        return prefix.concat(".csv");
    }

}
