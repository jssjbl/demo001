package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool  {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new RunableImpl());
        //线程池一直开启，使用完了会线程归还线程池，线程可以继续使用
        executorService.submit(new RunableImpl());
        executorService.submit(new RunableImpl());

    }
}
