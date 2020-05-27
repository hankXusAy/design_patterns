package com.xss.singleton;

/**
 * @ClassName Mgr05
 * @Description 懒汉式
 *              lazy loading
 *              虽然也达到了按需初始化的目的,但却带来线程不安全的问题
 *              可以通过synchronized解决,但是也降低了效率
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/5/27 7:29 PM
 * @Return
 */
public class Mgr05 {
    private static Mgr05 INSTANCE;

    private Mgr05() {
    }

    public static Mgr05 getInstance(){
        if(INSTANCE == null){
           synchronized (Mgr05.class){
               //双重检查,保证了安全性
               if(INSTANCE == null){
                   try {
                       Thread.sleep(1);
                   }catch (Exception e){

                   }
                   INSTANCE = new Mgr05();
               }
           }
        }
        return INSTANCE;
    }

    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Mgr05.getInstance().hashCode());
            }).start();
        }
    }
}
