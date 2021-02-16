package org.pr.mini.biz.services.transporters;

import org.pr.mini.biz.model.Car;
import org.pr.mini.biz.services.communicators.Messenger;
import org.pr.mini.core.annotations.InjectByType;

public class InternationalLandTransporter implements Transporter{
    @InjectByType
    private Messenger messenger;
    public void pickup(Car car) {
        System.out.println("Prepare your car, I'll pick it up!");
        messenger.notifyClient();
    }

    public void deliver(Car car) {
        System.out.println("Your " +car.toString() + " will be delivered to you soon. Be ready!");
    }
}
