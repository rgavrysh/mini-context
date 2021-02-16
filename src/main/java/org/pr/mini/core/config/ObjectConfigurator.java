package org.pr.mini.core.config;

import org.pr.mini.core.context.ApplicationContext;

/**
 * Implementations of this interface are responsible for object configuration,
 * like setting properties, inject dependencies, etc.
 * Object is being configured by {@link org.pr.mini.core.context.ObjectFactory}
 */
public interface ObjectConfigurator {

    /**
     * Configure object
     * @param t - object which needs to be configured
     * @param context - application context (may not always be required)
     */
    void configure(Object t, ApplicationContext context);
}
