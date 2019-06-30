package thread;

public class TestLearnThread {
    public static void main(String[] args) {
        LearnThread learnThread=new LearnThread();
        Thread t1=new Thread(learnThread);
        Thread t2=new Thread(learnThread);
        Thread t3=new Thread(learnThread);
        t1.start();
        t2.start();
        t3.start();
    }
}
