package org.pr.mini;

import org.pr.mini.biz.model.Car;
import org.pr.mini.biz.services.RepairCenter;
import org.pr.mini.biz.services.worker.BodyWorker;
import org.pr.mini.biz.services.worker.ChassisWorker;
import org.pr.mini.biz.services.worker.Worker;
import org.pr.mini.core.context.Application;
import org.pr.mini.core.context.ApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * This is a very short example of IoC frameworks.
 * The main idea is to show how context (bean container) manages object creation,
 * configuration or possible proxy wrapping.
 * {@link RepairCenter} is the main business logic service, which has one responsibility:
 * repair a car, apart from it contains two dependencies on {@link org.pr.mini.biz.services.transporters.Transporter} -
 * responsible for transporting an auto to repair station and deliver it back to customer, and
 * {@link Worker} - workforce responsible for assessing car and work estimation.
 * There is also a {@link org.pr.mini.biz.services.communicators.Messenger} which can be used by any service
 * and responsible for sending notification or message to customer.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = Application.run("org.pr.mini", new HashMap<>(Map.of(Worker.class, BodyWorker.class)));
        RepairCenter repairCenter = context.getObject(RepairCenter.class);
        repairCenter.start(new Car("audi"));
    }
}
