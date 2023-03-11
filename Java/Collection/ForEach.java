package Collection;

import java.util.ArrayList;

/**
 * @author Jim
 * @Description 增强 for 循环
 * @createTime 2022年11月09日
 */
public class ForEach {

    public static void main(String[] args) {

        // 使用增强for循环遍历数组
        int[] arr = {1,2,3,4,5,6,7};
        for(int i:arr){
            System.out.println(i);
        }

        // 使用增强for循环集合
        ArrayList<String> arr2 = new ArrayList<>();
        arr2.add("123");
        arr2.add("234");
        arr2.add("345");
        arr2.add("456");
        for(String a:arr2){
            System.out.println(a);
        }
    }
}
