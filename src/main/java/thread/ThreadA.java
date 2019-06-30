package thread;

public class ThreadA extends Thread {
   private    BaoZi baoZi;
   public ThreadA ( BaoZi baoZi){
       this.baoZi=baoZi;
   }
    @Override
    public void run() {
       while (true){
           synchronized (baoZi){
                   System.out.println("A");
                  baoZi.setFlag(false);
               try {
                   baoZi.wait();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       }
    }
}
