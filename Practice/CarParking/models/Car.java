package models;

import common.Type;

public class Car {
    String number;
    Type carType;

    public Car(String number) {
        this.number = number;
    }

    public Car(String number, Type carType) {
        this.number = number;
        this.carType = carType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Type getCarType() {
        return carType;
    }

    public void setCarType(Type carType) {
        this.carType = carType;
    }

}
