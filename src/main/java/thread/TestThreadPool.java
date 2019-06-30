package thread;

import org.junit.runner.RunWith;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThreadPool {
    public static void main(String[] args) {
        ThreadPoolExecutor pool=
                new ThreadPoolExecutor(1,2,3, TimeUnit.SECONDS,new LinkedBlockingQueue<>(3));
        //利用线程池的线程执行任务
        //第一个任务
        pool.execute(new  TestRead());
        //执行第二个任务
        pool.execute(new  TestRead());
        pool.execute(new  TestRead());
        pool.execute(new  TestRead());
        //执行第四个任务
        pool.execute(new  TestRead());
        //关闭线程池
        pool.shutdown();
    }
}
class TestRead implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}