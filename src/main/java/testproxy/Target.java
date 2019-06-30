package testproxy;

import java.util.ArrayList;
import java.util.List;

public class Target implements TargetInterface {
    @Override
    public void menthod1() {
        System.out.println("*********method1()");
    }

    @Override
    public String method2() {
        System.out.println("*********method2()");
        String method2 = "method2";
        List list= new ArrayList(10000);
        return method2;

    }

    @Override
    public int method3(int i) {
        return i;
    }
}
