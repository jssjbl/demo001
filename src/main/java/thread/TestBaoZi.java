package thread;

public class TestBaoZi {
    public static void main(String[] args) {
        BaoZi baoZi=new BaoZi();

        BaoZiPu baoZiPu=new BaoZiPu(baoZi);
        ChiHuo chiHuo = new ChiHuo(baoZi);
        Thread bThread=new Thread(baoZiPu);
        Thread cThread=new Thread(chiHuo);
        bThread.start();
        cThread.start();


    }
}
