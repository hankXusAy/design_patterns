package com.xss.factorymethod;

/**
 * @ClassName CarFactory
 * @Description
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/5/28 7:04 PM
 * @Return
 */
public class CarFactory {
    public Moveable createCar(){
        System.out.println("a car created!");
        return new Car();
    }
}
