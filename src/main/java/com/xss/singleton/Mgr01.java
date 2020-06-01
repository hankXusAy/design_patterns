package com.xss.singleton;

/**
 * @ClassName Mgr01
 * @Description 饿汉式单例模式
 *              类加载到内存后,就实例化一个单例对象,JVM保证线程安全
 *              简单实用,推荐使用
 *              唯一缺点:不管用到与否,类加载时都会完成实例化(话说你不用它,你装载它干啥)
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

    private Mgr01() {
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
