package org.pr.mini.biz.services.communicators;

import org.pr.mini.core.annotations.InjectProperty;
import org.pr.mini.core.annotations.Singleton;

/**
 * Using Singleton annotation on this class makes sure
 * that one instance of this class will be in application context.
 * To check it, remove @Singleton annotation and message in constructor
 * will be printed as many times as object has been created/requested.
 * {@link Deprecated} annotation will be read by {@link org.pr.mini.core.config.DeprecatedHandlerProxyConfigurator}
 * and processed accordingly. Uncomment @Deprecated annotation and check
 * that object is wrapped by Proxy class on object creation, and warning message
 * printed out on each method invocation.
 */
@Singleton
//@Deprecated
public class SMS implements Messenger {

    @InjectProperty("warning")
    //this annotation will look for "warning" property in application.properties file
    //if annotation without value, by default it will look for "message" property
    private String message;

    public SMS() {
        System.out.println("sms created");
    }

    @Override
    public void notifyClient() {
        System.out.println("send sms to a client: " + message);
    }
}
