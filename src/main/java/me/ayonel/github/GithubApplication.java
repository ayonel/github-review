package me.ayonel.github;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Description;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class GithubApplication {

	static {
		try{
			//初始化log4j
			String log4jPath = GithubApplication.class.getClassLoader().getResource("").getPath()+"/log4j.properties";
			System.out.println("初始化Log4j......");
			System.out.println("path is "+ log4jPath);
			PropertyConfigurator.configure(log4jPath);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	@Bean
	@Description("Spring Message Resolver")
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}




		public static void main(String[] args) {
		SpringApplication.run(GithubApplication.class, args);
	}
}
