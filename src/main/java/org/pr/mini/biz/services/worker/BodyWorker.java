package org.pr.mini.biz.services.worker;

import org.pr.mini.biz.model.Car;
import org.pr.mini.biz.services.communicators.Messenger;
import org.pr.mini.core.annotations.InjectByType;

import javax.annotation.PostConstruct;

public class BodyWorker implements Worker{

    @InjectByType
    private Messenger messenger;

    @PostConstruct
    public void init() {
        System.out.println(messenger.getClass());
    }

    @Override
    public void estimateWork(Car car) {
        System.out.println("to repair body of " + car.toString() + " will cost 500 $");
        messenger.notifyClient();
    }
}
