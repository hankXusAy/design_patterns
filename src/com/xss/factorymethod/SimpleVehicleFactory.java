package com.xss.factorymethod;

/**
 * @ClassName SimpleVehicleFactory
 * @Description 简单工厂,可扩展性不好
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/5/28 7:01 PM
 * @Return
 */
public class SimpleVehicleFactory {

    public Car createCar(){
        return new Car();
    }
    public Broom createBroom(){
        return new Broom();
    }
}
