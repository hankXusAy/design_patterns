package com.xss.factorymethod;

/**
 * @ClassName Broom
 * @Description
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/5/28 6:23 PM
 * @Return
 */
public class Broom implements Moveable{
    @Override
    public void go() {
        System.out.println("broom flying chuachuachua........");
    }
}
