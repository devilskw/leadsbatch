package br.com.kazuo.leadsbatch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableCaching
@EnableBatchProcessing
@EnableFeignClients
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class, scanBasePackages = "br.com.kazuo.leadsbatch")
@Slf4j
public class LeadsbatchApplication {

	public static void main(String[] args) {
		System.exit(
				SpringApplication.exit(
						SpringApplication.run(LeadsbatchApplication.class, args)
				)
		);
	}
}
