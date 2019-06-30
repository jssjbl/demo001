package File;

import lombok.Data;


import java.io.*;
@Data
public class ReadFile implements Runnable {
    private File files;
    private File file;
    InputStream ips;
    OutputStream ops;
    public  ReadFile(File files,File file){
        this.files=files;
        this.file=file;
    };
    @Override
    public void run() {
            try {
                ips = new FileInputStream(files);
                byte[] bytes = new byte[1024];
                int read = 0;
                ops=new FileOutputStream(file,true);
                while ((read=ips.read(bytes))!=-1){
                    ops.write(bytes,0,read);
                }
               Thread.currentThread().setName("此线程名称是---"+files.getName());
                System.out.println("此线程名称是---"+files.getName()+"时间为"+System.currentTimeMillis());
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    ops.close();
                    ips.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

    }
}
