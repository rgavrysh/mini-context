package org.pr.mini.core.config;

/**
 * Implementations of this interface are responsible for replacing object by proxy.
 * Proxy class can be used for cross cutting tasks, like transactions, notifications, etc.
 * As an example there is concrete implementation {@link DeprecatedHandlerProxyConfigurator}
 * which prints out warning message on each method invocation of class marked with
 * {@link Deprecated} annotation.
 */
public interface ProxyConfigurator {

    Object wrapWithProxy(Object t, Class implClass);
}
