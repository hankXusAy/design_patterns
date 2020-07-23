import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName HellpJOL
 * @Description 锁升级的过程
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/7/23 4:08 下午
 * @Return
 */
public class HelloJOL {
    public static void main(String[] args) throws InterruptedException {
        Object o1 = new Object();
        //无所状态
        System.out.println("无锁>>>"+ClassLayout.parseInstance(o1).toPrintable());

        synchronized (o1){
            System.out.println("自旋锁-轻量级锁>>>"+ClassLayout.parseInstance(o1).toPrintable());
        }
        Thread.sleep(5000);
        //默认情况 偏向锁有个时延，默认是4秒,5s后偏向锁开启
        /* 因为JVM虚拟机自己有一些默认启动的线程，里面有好多sync代码，这些sync代码启动时就知道肯定会有竞争，
        如果使用偏向锁，就会造成偏向锁不断的进行锁撤销和锁升级的操作，效率较低。*/
        Object o = new Object();
        System.out.println("匿名偏向>>>"+ClassLayout.parseInstance(o).toPrintable());
        //
        synchronized (o){
            System.out.println("偏向锁>>>"+ClassLayout.parseInstance(o).toPrintable());
        }
    }
}
