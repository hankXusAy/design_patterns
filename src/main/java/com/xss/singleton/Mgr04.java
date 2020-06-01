package com.xss.singleton;

/**
 * @ClassName Mgr04
 * @Description 懒汉式
 *              lazy loading
 *              虽然也达到了按需初始化的目的,但却带来线程不安全的问题
 *              可以通过synchronized解决,但是也降低了效率
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/5/27 7:29 PM
 * @Return
 */
public class Mgr04 {
    private static Mgr04 INSTANCE;

    private Mgr04() {
    }

    public static Mgr04 getInstance(){
        if(INSTANCE == null){
            //妄图通过减小代码块的方式提高效率,但是不可行
           synchronized (Mgr04.class){
               try {
                   Thread.sleep(1);
               }catch (Exception e){

               }
               INSTANCE = new Mgr04();
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
                System.out.println(Mgr04.getInstance().hashCode());
            }).start();
        }
    }
}
