package br.com.kazuo.leadsbatch.app.config.feign;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class FeignConfig {
    @Bean
    public Retryer retryer() {
        return new Retryer.Default(500L, TimeUnit.SECONDS.toMillis(5L), 7);
    }
}
