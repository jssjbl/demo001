package thread;

public class WaitAndNorify {
    public static void main(String[] args) {
        Object object=new Object();
       new Thread(
               new Runnable() {
                   @Override
                   public void run() {
                       //一直等着买包子
                       while (true){
                           synchronized (object){
                               System.out.println("开始点包子了");
                               try {
                                   object.wait();
                               } catch (InterruptedException e) {
                                   e.printStackTrace();
                               }
                           }
                           //唤醒之后要执行的代码
                           System.out.println("开始吃包子喽");
                           System.out.println("-----------");
                       }



                   }
               }
       ).start();
       new Thread(
               new Runnable() {
                   @Override
                   public void run() {
                       //一直做包子
                       while (true){
                           try {
                               Thread.sleep(5000);
                           } catch (InterruptedException e) {
                               e.printStackTrace();
                           }
                           synchronized (object){
                               System.out.println("等了5秒了，包子做好了，可以吃了");
                               object.notify();
                           }
                       }


                   }
               }
       ).start();
    }

}
