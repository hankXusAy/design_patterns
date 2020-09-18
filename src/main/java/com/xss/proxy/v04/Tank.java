package com.xss.proxy.v04;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

/**
 * @ClassName Tank
 * @Description
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/9/14 5:17 下午
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
        //System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles","true");
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Movable m = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(),
                new Class[]{Movable.class},
                new TimeProxy(tank)
        );
        m.move();
    }
}

class TimeProxy implements InvocationHandler {
    Movable movable;
    public TimeProxy(Movable movable) {
        this.movable = movable;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("method : " + method.getName() + "start.....");
        Object o = method.invoke(movable, args);
        System.out.println("method : " + method.getName() + "end.....");
        return o;
    }
}

interface Movable{
    void move();
}