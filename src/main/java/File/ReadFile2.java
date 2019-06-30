package File;

import lombok.Data;

import java.io.*;

@Data
public class ReadFile2  {
    private File files;
    private File file;
    InputStream ips;
    OutputStream ops;
    public ReadFile2(File files, File file){
        this.files=files;
        this.file=file;
    };
    public void copy() {
            try {
                ips = new FileInputStream(files);
                byte[] bytes = new byte[1024];
                int read = 0;
                ops=new FileOutputStream(file,true);
                while ((read=ips.read(bytes))!=-1){
                    ops.write(bytes,0,read);
                }
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
