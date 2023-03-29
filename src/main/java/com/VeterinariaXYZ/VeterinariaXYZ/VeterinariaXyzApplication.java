package com.VeterinariaXYZ.VeterinariaXYZ;

import com.VeterinariaXYZ.VeterinariaXYZ.config.FiltrosCors;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableTransactionManagement
@ServletComponentScan
@EnableCaching
@EnableWebMvc
public class VeterinariaXyzApplication {

	public static void main(String[] args) {
		SpringApplication.run(VeterinariaXyzApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean<FiltrosCors> corsFilterRegistration() {
		FilterRegistrationBean<FiltrosCors> registrationBean = new FilterRegistrationBean<>(new FiltrosCors());
		registrationBean.setName("filtros CORS");
		registrationBean.addUrlPatterns("/*");
		registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return registrationBean;
	}
}
