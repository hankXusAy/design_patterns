package com.xss.proxy.v01;


import java.util.Random;

/**
 * @ClassName Tank
 * @Description 静态代理
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/9/14 4:09 下午
 * @Return
 */
public class Tank implements Movable {

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
        new TankTimeProxy(new Tank()).move();
    }
}

class TankTimeProxy implements Movable{

    //只能代理坦克,不够灵活
    Tank tank;
    public TankTimeProxy(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        tank.move();
        long end = System.currentTimeMillis();
        System.out.println("tank 移动了" + (end - start) + "毫秒");
    }
}
//class TankLogProxy implements Movable{
//
//    Tank tank;
//    public TankLogProxy(Tank tank) {
//        this.tank = tank;
//    }
//
//    @Override
//    public void move() {
//        System.out.println("日志记录........");
//        tank.move();
//        System.out.println("日志记录结束了...............");
//    }
//}
interface Movable{
    void move();
}
