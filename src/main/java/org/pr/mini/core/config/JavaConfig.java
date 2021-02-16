package org.pr.mini.core.config;

import lombok.Getter;
import org.reflections.Reflections;

import java.util.Map;
import java.util.Set;

public class JavaConfig implements Config {
    @Getter
    private Reflections scanner;
    private Map<Class, Class> iface2Impl;

    public JavaConfig(String packageToScan, Map<Class, Class> iface2Impl) {
        this.iface2Impl = iface2Impl;
        this.scanner = new Reflections(packageToScan);
    }

    @Override
    public <T> Class<? extends T> getImplClass(Class<T> iface) {
        return iface2Impl.computeIfAbsent(iface, aClass -> {
            Set<Class<? extends T>> classes = scanner.getSubTypesOf(iface);
            if (classes.size() != 1) {
                throw new RuntimeException(iface + " has 0 or more than 1 implementation");
            }

            return classes.iterator().next();

        });
    }
}
