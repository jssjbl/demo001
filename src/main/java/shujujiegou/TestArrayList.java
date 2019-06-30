package shujujiegou;

public class TestArrayList {
    public static void main(String[] args) {
       List list=new ArrayList(4);
        list.add(123);
        list.add(321);
        list.add(789);
        list.add(456);
        System.out.println(list.size());
        System.out.println(list.get(-8));
        System.out.println(list.isEmpty());
    }
}
