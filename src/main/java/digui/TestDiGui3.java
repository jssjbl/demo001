package digui;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 使用递归打印文件夹下的所有文件
 */
public class TestDiGui3 {
    static List<String > list=new ArrayList<>();
    public static void main(String[] args) {
        TestDiGui3 testDiGui3=new TestDiGui3();
        List<String> sum = testDiGui3.sum(new File("C:\\testdigui"),TestDiGui3.list);
        for (int i = 0; i <sum.size() ; i++) {
            System.out.println(sum.get(i));
        }

    }
    /**
     * 定义一份方法计算1-n之间的和
     * 1*2*3*...+n
     * n*(n-1)*(n-2)*...l
     * 已知：最大值，最小值
     * 使用递归必须明确：
     * 1，递归的结束条件
     *    获取到1的时候结束
     * 2.递归的目的
     *    获取下一个被乘的数字（n-1）
     */
    private  List<String > sum(File file,List<String> list){
            if(file.isDirectory()){
                File[] list1 = file.listFiles();
                for (int i = 0; i <list1.length ; i++) {
                    list.add(list1[i].getAbsolutePath());
                    sum(list1[i],list);
                }
                return list;
            }
        return null;
    }
}
