package thread;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LearnThread implements Runnable{
 private Integer count=100;

@Override
    public void run(){
    while (true){
        synchronized (this){
            if(count>0){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"正在卖第"+count+"张票");
                count--;
            }
        }

    }
    }
}
