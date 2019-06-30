package digui;

/**
 * 使用递归计算1-n的和
 */
public class TestDiGui {
    public static void main(String[] args) {
        int sum = sum(100);
        System.out.println(sum);
    }
    /**
     * 定义一份方法计算1-n之间的和
     * 1+2+3+...+n
     * n+(n-1)+(n-2)+...l
     * 已知：最大值，最小值
     * 使用递归必须明确：
     * 1，递归的结束条件
     *    获取到1的时候结束
     * 2.递归的目的
     *    获取下一个被加的数字（n-1）
     */
    private static int sum(int n){
        //获取结束的条件
        if(n==1){
            return 1;
        }
        //获取下一个被加的数字（n-1）
        return n+sum(n-1);
    }
}
