package org.pr.mini.core.context;

import lombok.Getter;
import lombok.Setter;
import org.pr.mini.core.annotations.Singleton;
import org.pr.mini.core.config.Config;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This is an application context and bean container.
 * Responsible for object provisioning requested by application.
 * {@link Singleton} are handled accordingly (one singleton service per application context).
 * By best practices Singleton should be stateless service.
 */
public class ApplicationContext {
    @Setter
    private ObjectFactory factory;
    private Map<Class, Object> cache = new ConcurrentHashMap<>();
    @Getter
    private Config config;

    public ApplicationContext(Config config) {
        this.config = config;
    }

    public <T> T getObject(Class<T> type) {
        Class<? extends T> implClass = type;
        if (cache.containsKey(type)) {
            return (T) cache.get(type);
        }

        if (type.isInterface()) {
            implClass = config.getImplClass(type);
        }

        T t = factory.createObject(implClass);

        if (implClass.isAnnotationPresent(Singleton.class)) {
            cache.put(type, t);
        }

        return t;
    }
}
