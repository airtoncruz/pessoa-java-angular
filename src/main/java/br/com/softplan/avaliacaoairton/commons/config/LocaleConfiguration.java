package br.com.softplan.avaliacaoairton.commons.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 * Classe de configuracao de localidade, responsável por adicionar um interceptor para
 * ajustar a localidade da aplicacao de acordo com o parametro language da request
 * tornando poss;ivel assim a internacionalizacao
 * @author airton.cruz
 * @since 1.0 (30/09/2020)
 */
@EnableWebMvc
@Configuration
public class LocaleConfiguration implements WebMvcConfigurer {

    @Bean(name = "localeResolver")
    public LocaleResolver localeResolver() {

        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(Locale.US);

        return sessionLocaleResolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();

        localeChangeInterceptor.setParamName("language");

        registry.addInterceptor(localeChangeInterceptor);
    }

}
