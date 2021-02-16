package org.pr.mini.core.context;

import org.pr.mini.core.config.JavaConfig;

import java.util.Map;

public class Application {
    /**
     * This is an application bootstrap method.
     * Creates {@link org.pr.mini.core.config.Config},
     * {@link ObjectFactory} and setup {@link ApplicationContext}
     * @param packageToScan - packages to scan while looking for class implementations
     * @param iface2Class - map for concrete implementation against interface as a key
     * @return {@link ApplicationContext}
     */
    public static ApplicationContext run(String packageToScan, Map<Class, Class> iface2Class) {
        JavaConfig javaConfig = new JavaConfig(packageToScan, iface2Class);
        ApplicationContext context = new ApplicationContext(javaConfig);
        ObjectFactory objectFactory = new ObjectFactory(context);
        context.setFactory(objectFactory);
        return context;
    }
}
