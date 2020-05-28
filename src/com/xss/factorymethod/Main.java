package com.xss.factorymethod;

/**
 * @ClassName Main
 * @Description 工厂模式
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/5/28 4:32 PM
 * @Return
 */
public class Main {
    public static void main(String[] args) {
//        Car car = new Car();
//        car.go();
//        Plane p = new Plane();
////        p.go();
    Moveable m = new CarFactory().createCar();
    m.go();

    }
}
