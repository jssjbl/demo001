package thread;

public class ab {
    public static void main(String[] args) {
        Object object =new Object();
       new Thread(new Runnable() {
           @Override
           public void run() {
               while (true){
                   synchronized (object){
                       System.out.println("A");
                       try {
                           object.wait();
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   }
               }


           }
       }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    synchronized (object){
                        System.out.println("B");
                        object.notify();
                    }
                }


            }
        }).start();


    }
}
