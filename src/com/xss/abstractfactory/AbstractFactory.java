package com.xss.abstractfactory;

/**
 * @ClassName AbastracFactory
 * @Description
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/5/29 9:24 PM
 * @Return
 */
public abstract class AbstractFactory {

    abstract Food createFood();

    abstract Vehicle createVehicle();

    abstract Weapon createWeapon();

}
