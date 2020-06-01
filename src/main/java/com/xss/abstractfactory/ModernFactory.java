package com.xss.abstractfactory;

/**
 * @ClassName ModernFactory
 * @Description
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/5/29 9:36 PM
 * @Return
 */
public class ModernFactory extends AbstractFactory {
    @Override
    Food createFood() {
        return new Bread();
    }

    @Override
    Vehicle createVehicle() {
        return new Car();
    }

    @Override
    Weapon createWeapon() {
        return new AK47();
    }
}
