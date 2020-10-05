package br.com.softplan.avaliacaoairton.commons.context;

import java.util.HashMap;
import java.util.Map;

/**
 * Representa as informações do usuário da sessão.
 *
 * @author airton.cruz
 * @since 1.0 (29/09/2020)
 */
public class UserSession {

    private final Map<String, Object> session = new HashMap();

    /**
     * Busca informações do usuário da sessão referente a chave informada.
     *
     * @param key - chave da informação armazenada.
     * @return valor da contido para a chave.
     */
    public Object get(final String key) {
        return session.get(key);
    }

    /**
     * Atribui informação do usuário na sessão.
     *
     * Importante: A informação só é adicionado caso não exista a chave.
     *
     * @param key chave da informação a ser armazenada.
     * @param value valor a ser armazenado na sessão para a chave.
     */
    public void put(final String key, final Object value) {
        session.putIfAbsent(key, value);
    }
}
