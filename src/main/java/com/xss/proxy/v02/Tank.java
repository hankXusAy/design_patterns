package com.xss.proxy.v02;

import java.util.Random;

/**
 * @ClassName Tank1
 * @Description  静态代理
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/9/14 4:19 下午
 * @Return
 */
public class Tank implements Movable{


    @Override
    public void move() {
        System.out.println("calacalcalacala");
        try {
            Thread.sleep(new Random().nextInt(10000));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new TankTimeProxy(new TankLogProxy(new Tank())).move();
//        new TankLogProxy(new TankTimeProxy(new Tank())).move();
    }
}

class TankTimeProxy implements Movable{

    //只能代理坦克,不够灵活
    Movable movable;

    public TankTimeProxy(Movable movable) {
        this.movable = movable;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        movable.move();
        long end = System.currentTimeMillis();
        System.out.println("tank 移动了" + (end - start) + "毫秒");
    }
}
class TankLogProxy implements Movable{

    Movable movable;

    public TankLogProxy(Movable movable) {
        this.movable = movable;
    }

    @Override
    public void move() {
        System.out.println("日志记录开始了...............");
        movable.move();
        System.out.println("日志记录结束了...............");
    }
}
interface Movable{
    void move();
}
