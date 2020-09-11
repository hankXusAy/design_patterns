package com.xss.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Child
 * @Description 观察者模式
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/9/11 4:39 下午
 * @Return
 */
public class Child {
    private boolean cry = false;
    private List<Observer> observerList = new ArrayList<>();
    {
        observerList.add(new Dad());
        observerList.add(new Mom());
        observerList.add(new Dog());
    }

    private boolean isCry(){
        return cry;
    }
    public void wakeUp(){
        cry = true;
        for (Observer observer : observerList) {
            WakeUpEvent wakeUpEvent = new WakeUpEvent(System.currentTimeMillis(),"地上",this);
            observer.actionOnWakeUp(wakeUpEvent);
        }
    }

    public static void main(String[] args) {
        Child child = new Child();
        child.wakeUp();
    }
}

abstract class EventSource<T>{
    abstract T getSource();
}
//事件
class WakeUpEvent extends EventSource<Child>{
    long timestamp;
    String loc;
    Child source;

    public WakeUpEvent(long timestamp, String loc, Child source) {
        this.timestamp = timestamp;
        this.loc = loc;
        this.source = source;
    }


    @Override
    public Child getSource() {
        return source;
    }
}


interface Observer{
    //观察者只和事件打交道,不和事件源source打交道---解耦合
    void actionOnWakeUp(WakeUpEvent wakeUpEvent);
}

class Dad implements Observer{

    public void feed(){
        System.out.println("feed......");
    }
    @Override
    public void actionOnWakeUp(WakeUpEvent wakeUpEvent) {
        System.out.println("事件源 : " + wakeUpEvent.getSource().getClass());
        feed();
    }
}
class Mom implements Observer{

    public void hug(){
        System.out.println("hug........");
    }
    @Override
    public void actionOnWakeUp(WakeUpEvent wakeUpEvent) {
        hug();
    }
}
class Dog implements Observer{

    public void wangwang(){
        System.out.println("wangwang.....");
    }

    @Override
    public void actionOnWakeUp(WakeUpEvent wakeUpEvent) {
        wangwang();
    }
}