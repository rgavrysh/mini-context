package org.pr.mini.core.config;

import org.reflections.Reflections;

/**
 * This Config is responsible for scanning implementation class
 * by provided interface.
 * Its concrete implementation {@link JavaConfig}, determines multiple implementations
 * based on simple map provided on application initialization (Java configuration).
 */
public interface Config {
    <T> Class<? extends T> getImplClass(Class<T> iface);

    Reflections getScanner();
}
