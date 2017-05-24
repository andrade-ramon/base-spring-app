package com.springbase.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

@Configuration
public class TemplateEngineProducer {

	@Bean
	@Autowired
	public TemplateEngine createTemplateEngine(TemplateResolver templateResolver) {
		TemplateEngine templateEngine = new TemplateEngine();
		templateEngine.addTemplateResolver(templateResolver);

		return templateEngine;
	}

	@Bean(name = "templateResolver")
	public TemplateResolver emailTemplateResolver() {
		TemplateResolver templateResolver = new ClassLoaderTemplateResolver();
		templateResolver.setTemplateMode("LEGACYHTML5");
		templateResolver.setCharacterEncoding("UTF-8");
		templateResolver.setPrefix("templates/");
		templateResolver.setSuffix(".html");
		templateResolver.setCacheable(false);
		templateResolver.setOrder(1);
		
		return templateResolver;
	}
}