package com.xss.abstractfactory;

/**
 * @ClassName MagicStickFactory
 * @Description
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/5/29 9:38 PM
 * @Return
 */
public class MagicStickFactory extends AbstractFactory {
    @Override
    Food createFood() {
        return new MashRoom();
    }

    @Override
    Vehicle createVehicle() {
        return new Broom();
    }

    @Override
    Weapon createWeapon() {
        return new MagicStick();
    }
}
