package thread;

public class TestAB {
    public static void main(String[] args) {
        BaoZi baoZi=new BaoZi();
        baoZi.setFlag(true);
        ThreadA a=new ThreadA(baoZi);
        ThreadB b=new ThreadB(baoZi);
            a.start();
            b.start();
    }
}
