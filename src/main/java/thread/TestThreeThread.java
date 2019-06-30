package thread;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
//Callable<Integer> 泛型的类型表示线程体返回结果的类型，即重写的call方法的返回值类型
public class TestThreeThread implements Callable<Integer> {
    //重写call方法，这个方法，有返回值类型
    @Override
    public Integer call() throws Exception {
        return new Random().nextInt();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //缺点：创建线程方法比较繁琐
        //创建线程对象
        TestThreeThread testThreeThread=new TestThreeThread();
        //启动线程
        FutureTask<Integer> ft=new FutureTask<>(testThreeThread);
        Thread thread=new Thread(ft);
        thread.start();
        //返回值自己获取：
        Integer i=ft.get();
        System.out.println(i);
    }
}
