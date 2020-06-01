package com.xss.abstractfactory;

import com.xss.factorymethod.CarFactory;
import com.xss.factorymethod.Moveable;

/**
 * @ClassName Main
 * @Description 工厂模式-抽象工厂  形容词用接口(可以干什么的用接口),名词用抽象类(本身就是名词的用抽象类)
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/5/28 4:32 PM
 * @Return
 */
public class Main {
    public static void main(String[] args) {
//        Car car = new Car();
//        car.go();
//        MagicStick magicStick = new MagicStick();
//        magicStick.shoot();
//        Bread bread = new Bread();
//        bread.printName();
        AbstractFactory f = new ModernFactory();
        //需要魔法世界的产品,new 一个ModernFactory,需要火星世界的产品族,再创建火星世界的产品族,继承AbstractFactory
        Vehicle v = f.createVehicle();
        v.go();
        Food food = f.createFood();
        food.printName();
        Weapon weapon = f.createWeapon();
        weapon.shoot();
    }
}
