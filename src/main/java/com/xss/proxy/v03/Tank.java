package com.xss.proxy.v03;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

/**
 * @ClassName Tank
 * @Description 动态代理
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/9/14 4:55 下午
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
        Tank tank = new Tank();
        Movable m = (Movable)Proxy.newProxyInstance(Tank.class.getClassLoader(),
                new Class[]{Movable.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
                        System.out.println("method : " + method.getName() + "start.....");
                        Object o = method.invoke(tank, args);
                        System.out.println("method : " + method.getName() + "end.....");
                        return o;
                    }
                });
        m.move();
    }
}

interface Movable{
    void move();
}