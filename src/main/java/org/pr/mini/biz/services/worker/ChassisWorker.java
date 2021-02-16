package org.pr.mini.biz.services.worker;

import org.pr.mini.biz.model.Car;

public class ChassisWorker implements Worker{
    public void estimateWork(Car car) {
        System.out.println("to repair chassis of " + car.toString() + " will cost 1_000 $");
    }
}
