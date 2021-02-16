package org.pr.mini.biz.model;

public class Car {
    private String model;
    public Car(String modelName) {
        this.model = modelName;
    }

    @Override
    public String toString() {
        return model;
    }
}
