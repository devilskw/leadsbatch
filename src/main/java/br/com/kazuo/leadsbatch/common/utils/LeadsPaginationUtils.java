package br.com.kazuo.leadsbatch.common.utils;

import org.springframework.context.annotation.Configuration;

@Configuration
public class LeadsPaginationUtils {

    public Integer getTotalPages(Integer firstPageIndex, Integer pagesize, Integer totalElements) {
        if (totalElements == null || totalElements < 0 || pagesize == null || pagesize <= 0) {
            return 0;
        }
        if (firstPageIndex == null) {
            firstPageIndex = 0;
        }
        return (int)(totalElements / pagesize ) + ((totalElements % pagesize) > 0 ? 1 : 0) ;
    }
}
