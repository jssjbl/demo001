package File;

import java.io.*;

public class TestOutputStream {
    public static void main(String[] args) throws IOException {
        Long start=System.currentTimeMillis();
        OutputStream ops=new FileOutputStream("E:\\copy\\1\\心迷宫.HD.720p.国语中字.rmvb",true);
//        for (int i = 0; i < 10; i++) {
//            ops.write("你好啊".getBytes());
//            ops.write("\r\n".getBytes());
//        }
//        ops.close();
        InputStream ips=new FileInputStream("E:\\copy\\1\\[阳光电影www.ygdy8.com].心迷宫.HD.720p.国语中字.rmvb");
        byte[] bytes = new byte[1024];
        int read = 0;
        while ((read=ips.read(bytes))!=-1) {
            ops.write(bytes,0,read);
        }
        ops.close();
        ips.close();
        Long end=System.currentTimeMillis();
        System.out.println("复制共耗时"+(end-start)+"毫秒");
    }
}
