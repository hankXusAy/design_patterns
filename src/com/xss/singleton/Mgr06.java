package com.xss.singleton;

/**
 * @ClassName Mgr06
 * @Description 懒汉式-静态内部类方式
 *              lazy loading
 *              JVM保证单例
 *              加载外部类时不会加载内部类,这样可以实现懒加载
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/5/27 7:29 PM
 * @Return
 */
public class Mgr06 {

    private Mgr06() {
    }

    //非常完美,只能由内部类进行加载,只有内部类才持有该实例
    private static class Mgr06Holder{
        private static final Mgr06 INSTANCE = new Mgr06();
    }
    public static Mgr06 getInstance(){
        return Mgr06Holder.INSTANCE;
    }

    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Mgr06.getInstance().hashCode());
            }).start();
        }
    }
}
