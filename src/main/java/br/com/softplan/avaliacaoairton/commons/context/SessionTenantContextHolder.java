package br.com.softplan.avaliacaoairton.commons.context;

/**
 * Thread Local para armazanar na sessão o UserSession, fica visível para todas as Thread descendentes.
 *
 * @author airton.cruz
 * @since 1.0 (29/09/2020)
 */
public class SessionTenantContextHolder {

    private static final ThreadLocal<UserSession> currentSessionTenant = new InheritableThreadLocal<>();

    /**
     * Obtem o UserSession da request.
     * @return UserSession.
     */
    public static UserSession get() {
        return currentSessionTenant.get();
    }

    /**
     * Adiciona o UserSession na sessão do request.
     * @param userSession
     */
    public static void set(UserSession userSession) {

        currentSessionTenant.set(userSession);
    }

    public static void clearContext() {
        currentSessionTenant.remove();
    }
}
