package thread;

public class ThreadB extends Thread {
    private BaoZi baoZi;
    public ThreadB(BaoZi baoZi){
        this.baoZi=baoZi;
    }
    @Override
    public  void run(){
        while (true){
            synchronized (baoZi){
                if(!baoZi.getFlag()){
                    System.out.println("B");
                    baoZi.setFlag(true);
                }
                baoZi.notify();
            }
        }
    }
}
