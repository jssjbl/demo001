package File;

import thread.ThreadA;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestReadFile {
    public static void main(String[] args) {
        File fileForm=new File("E:\\新建文件夹 (4)");
        File fileTo=new File("E:\\新建文件夹 (5)");
        File[] files = fileForm.listFiles();
        Long start=System.currentTimeMillis();
        System.out.println(start);
        for (int i = 0; i <files .length; i++) {
            ReadFile readFile=new ReadFile(files[i],new File(fileTo+"\\"+files[i].getName()));
            Thread thread=new Thread(readFile);
            thread.start();
        }
        Long end=System.currentTimeMillis();
        System.out.println(end);
        System.out.println("总共耗时为"+(end-start));


//        ExecutorService executorService = Executors.newFixedThreadPool(10);


    }
}
