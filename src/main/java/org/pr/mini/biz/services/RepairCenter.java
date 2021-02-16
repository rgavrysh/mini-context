package org.pr.mini.biz.services;

import org.pr.mini.biz.model.Car;
import org.pr.mini.biz.services.transporters.Transporter;
import org.pr.mini.biz.services.worker.Worker;
import org.pr.mini.core.annotations.InjectByType;

public class RepairCenter {

    @InjectByType
    private Transporter transporter;
    @InjectByType
    private Worker worker;

    public void start(Car car) {
        transporter.pickup(car);
        worker.estimateWork(car);
        repair(car);
        transporter.deliver(car);
    }

    private void repair(Car car) {
        System.out.println("auto is being repaired ... ready!");
    }
}
