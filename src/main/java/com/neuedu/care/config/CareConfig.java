package com.neuedu.care.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.filter.FormContentFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.neuedu.care.converter.MyDateConverter;
import com.neuedu.care.intercepter.LoginIntercepter;



@SpringBootConfiguration
public class CareConfig extends WebMvcConfigurationSupport{
	@Autowired
	private MyDateConverter myDateConverter;
	@Autowired
	private LoginIntercepter loginIntercepter;
	
	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginIntercepter)
		.addPathPatterns("/**")
		.excludePathPatterns("/login","/checklogin","/exit",
				"/druid/**",
				"/swagger-ui.html/**","/v2/**","/swagger-resources/**",
				"/webjars/**");
		super.addInterceptors(registry);
	}
	
	@Override
	protected void addFormatters(FormatterRegistry registry) {
		registry.addConverter(myDateConverter);
		super.addFormatters(registry);
	}
	
	@Bean
	public FormContentFilter httpPutFormContentFilter() {
		return new FormContentFilter();
	}

	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**")
		.addResourceLocations("classpath:/META-INF/resources/")
		.addResourceLocations("classpath:/templates/");
		registry.addResourceHandler("/webjars/**")
		.addResourceLocations("/webjars/")
		.resourceChain(false);
		super.addResourceHandlers(registry);
	}

	@Override
	protected void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowCredentials(true)
			.allowedMethods("GET","POST","DELETE","PATCH","OPTIONS","HEAD","PUT").maxAge(3600*48);
		super.addCorsMappings(registry);
	}
}
