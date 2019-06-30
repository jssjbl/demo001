package thread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestFourThreadPool {
    public static void main(String[] args) {
        //可缓存的线程池
       /* ExecutorService threadPool= Executors.newCachedThreadPool();
        for (int i = 0; i <100 ; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            }); threadPool.shutdown();
        };
        */
        //定长线程池
       /* ExecutorService threadPool= Executors.newFixedThreadPool(3);
        for (int i = 0; i <100 ; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
         threadPool.shutdown();*/
       //定时的线程池
        /*ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(3);
        for (int i = 0; i <100 ; i++) {
            Runnable runnable=new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            };
            threadPool.schedule(runnable,10, TimeUnit.SECONDS);
        }
        threadPool.shutdown();*/

        //单例线程池
         ExecutorService threadPool= Executors.newSingleThreadExecutor();
        for (int i = 0; i <100 ; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });

        }
        threadPool.shutdown();
    }
}
