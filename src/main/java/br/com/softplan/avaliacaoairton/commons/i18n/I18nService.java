package br.com.softplan.avaliacaoairton.commons.i18n;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

/**
 * Service responsável por consulta de msg internaciolalizada.
 *
 * @author airton.cruz
 * @since 1.0 (29/09/2020)
 */
@Service
public class I18nService {

    @Autowired
    private MessageSource messageSource;

    public String i(String key, Object... args) {

        Locale locale = LocaleContextHolder.getLocale();

        return this.messageSource.getMessage(key, args, locale);

    }
}
