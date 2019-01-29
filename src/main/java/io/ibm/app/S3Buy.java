package io.ibm.app;

import io.ibm.app.filter.CorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class S3Buy extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(S3Buy.class, args);
	}

	@Bean
	public FilterRegistrationBean corsFilter(){
		FilterRegistrationBean freg=new FilterRegistrationBean();
		freg.setFilter(new CorsFilter());
		ArrayList<String> al=new ArrayList<>();
		al.add("/*");
		freg.setUrlPatterns(al);
		return freg;
	}
    @Override
	public SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(S3Buy.class);
	}

}
