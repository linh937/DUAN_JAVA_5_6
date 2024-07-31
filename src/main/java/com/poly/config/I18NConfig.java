package com.poly.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;


@Configuration
public class I18NConfig implements WebMvcConfigurer {
	@Bean("messageSource")
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
		ms.setDefaultEncoding("UTF-8");
		ms.setBasenames("classpath:i18n/message_en","classpath:i18n/global");
		return ms;
	}
	
//	@Bean
//	public LocaleResolver getLocaleResolver() {
//		CookieLocaleResolver cookie = new CookieLocaleResolver();
//		cookie.setDefaultLocale(new Locale("en"));
//		cookie.setCookiePath("/");
//		cookie.setCookieMaxAge(10 * 24 * 60 * 60);
//		return cookie;
//	}

	@Bean
	public LocaleResolver localeResolver()
	{
	    final SessionLocaleResolver localeResolver = new SessionLocaleResolver();
	    localeResolver.setDefaultLocale(new Locale("vi", "VN"));
	    return localeResolver;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		lci.setParamName("lang");
		registry.addInterceptor(lci)
		.addPathPatterns("/**");
	}
	
}
