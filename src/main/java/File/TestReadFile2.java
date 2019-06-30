package File;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestReadFile2 {
    public static void main(String[] args) {
        File fileForm=new File("E:\\新建文件夹 (4)");
        File fileTo=new File("E:\\新建文件夹 (5)");
        File[] files = fileForm.listFiles();
        Long start=System.currentTimeMillis();;
        for (int i = 0; i <files .length; i++) {
            ReadFile2 readFile=new ReadFile2(files[i],new File(fileTo+"\\"+files[i].getName()));
           readFile.copy();
        }
        Long end=System.currentTimeMillis();
        System.out.println("总共耗时为"+(end-start));
    }
}
