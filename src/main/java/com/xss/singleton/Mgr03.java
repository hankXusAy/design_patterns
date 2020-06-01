package com.xss.singleton;

/**
 * @ClassName Mgr03
 * @Description 懒汉式
 *              lazy loading
 *              虽然也达到了按需初始化的目的,但却带来线程不安全的问题
 *              可以通过synchronized解决,但是也降低了效率
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/5/27 7:29 PM
 * @Return
 */
public class Mgr03 {
    private static Mgr03 INSTANCE;

    private Mgr03() {
    }

    public synchronized static Mgr03 getInstance(){
        if(INSTANCE == null){
            try {
                Thread.sleep(1);
            }catch (Exception e){

            }
            INSTANCE = new Mgr03();
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
