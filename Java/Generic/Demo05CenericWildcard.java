package Generic;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Jim
 * @Description 泛型通配符
 * @createTime 2022年11月10日
 *
 * ? 代表任意的数据模型
 * 使用方式：
 *      不能创建对象是用
 *      只能作为方法的参数使用
 */
public class Demo05CenericWildcard {
    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(1);
        arr1.add(2);
        printArray(arr1);

        ArrayList<String> arr2 = new ArrayList<>();
        arr2.add("3");
        arr2.add("4");
        printArray(arr2);

//        ArrayList<?> arr3 = new ArrayList<>();
//        arr3.add(123);
//        arr3.add("123");

        // 要求：定义一个方法，能遍历所有类型的 ArrayList 集合（使用泛型的通配符）
        // 泛型没有继承概念
    }

    public static void printArray(ArrayList<?> list){
        Iterator<?> it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
