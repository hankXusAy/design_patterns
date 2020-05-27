package com.xss.singleton;

/**
 * @ClassName Mgr01
 * @Description 饿汉式单例模式
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/5/27 7:13 PM
 * @Return
 */
public class Mgr01 {
    private static Mgr01 INSTANCE = new Mgr01();

    public void m (){
        System.out.println("m");
    }

    public Mgr01() {
    }
    private static Mgr01 getInstance(){
        return INSTANCE;
    }

    public static void main(String[] args) {
        Mgr01 instance1 = Mgr01.getInstance();
        Mgr01 instance2 = Mgr01.getInstance();
        System.out.println(instance1 == instance2);
    }
}
