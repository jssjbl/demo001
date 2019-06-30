package thread;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChiHuo implements Runnable{
    private BaoZi baoZi;
    public ChiHuo(BaoZi baoZi){
        this.baoZi=baoZi;
    }

    @Override
    public void run() {
        while (true){
            synchronized (baoZi){
                if(baoZi.getFlag()==true){
                    System.out.println("吃"+baoZi.getPi()+baoZi.getXian()+"喽");
                }else {
                    try {
                        baoZi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("吃"+baoZi.getPi()+baoZi.getXian()+"喽");
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                baoZi.setFlag(false);
                baoZi.notify();
                System.out.println("花了两秒吃了"+baoZi.getPi()+baoZi.getXian()+"包子，还想再吃");
                System.out.println("---------------------------");

            }
        }
    }
}
