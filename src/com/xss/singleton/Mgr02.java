package com.xss.singleton;

/**
 * @ClassName Mgr02
 * @Description 懒汉式
 *              lazy loading
 *              虽然也达到了按需初始化的目的,但却带来线程不安全的问题
 *
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/5/27 7:29 PM
 * @Return
 */
public class Mgr02 {
    private static Mgr02 INSTANCE;

    private Mgr02() {
    }

    public static Mgr02 getInstance(){
        if(INSTANCE == null){
            try {
                Thread.sleep(1);
            }catch (Exception e){

            }
            INSTANCE = new Mgr02();
        }
        return INSTANCE;
    }

    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Mgr02.getInstance().hashCode());
            }).start();
        }
    }
}
