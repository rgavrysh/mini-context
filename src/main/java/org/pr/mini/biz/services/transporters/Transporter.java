package org.pr.mini.biz.services.transporters;

import org.pr.mini.biz.model.Car;

public interface Transporter {
    void pickup(Car car);

    void deliver(Car car);
}
