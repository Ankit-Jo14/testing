package com.websystique.springmvc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.websystique.springmvc")
public class HelloWorldConfiguration extends WebMvcConfigurerAdapter {
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	
	 @Bean
	    public UrlBasedViewResolver getViewResovler() {
		 UrlBasedViewResolver urlBasedViewResolver = new UrlBasedViewResolver();
	        urlBasedViewResolver.setViewClass(JstlView.class);
	        urlBasedViewResolver.setPrefix("/WEB-INF/pages/");
	        urlBasedViewResolver.setSuffix(".jsp");
	        return urlBasedViewResolver;
	    }

}