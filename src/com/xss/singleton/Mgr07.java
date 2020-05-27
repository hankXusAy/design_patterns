package com.xss.singleton;

/**
 * @ClassName Mgr07
 * @Description 枚举类单例,不仅可以解决线程同步,还可以防止反序列化
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/5/27 7:29 PM
 * @Return
 */
public enum  Mgr07 {
    INSTANCE;
    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 300; i++) {
            new Thread(()->{
                System.out.println(Mgr07.INSTANCE.hashCode());
            }).start();
        }
    }
}
