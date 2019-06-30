package thread;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BaoZiPu implements Runnable {
    private BaoZi baoZi;
    private  int count=0;
    public BaoZiPu(BaoZi baoZi){
        this.baoZi=baoZi;
    }
    @Override
    public void run() {
        //让包子铺一直生产包子
        while (true){
            synchronized (baoZi){
                if(baoZi.getFlag()==true){
                    try {
                        baoZi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //被唤醒之后，包子铺生产包子
                //增减一些趣味性，交替生产两种包子
                if(count%2==0){
                    //生产薄皮三鲜馅包子
                    baoZi.setPi("薄皮");
                    baoZi.setXian("三鲜");
                }else {
                    baoZi.setPi("冰皮");
                    baoZi.setXian("牛肉大葱");
                }
                count++;
                System.out.println("包子铺正在生产"+baoZi.getPi()+baoZi.getXian()+"包子");
                //生产包子需要三秒钟
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                baoZi.setFlag(true);
                baoZi.notify();
                System.out.println("包子铺已经生产了"+baoZi.getPi()+baoZi.getXian()+"包子，可以开始吃了");
            }
        }

    }
}
