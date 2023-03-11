package Collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jim
 * @Description
 * @createTime 2022年11月10日
 */
public class DemoArrayList {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(777);

        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list);
        list.add(2,777);
        System.out.println(list);
        System.out.println(list.set(8, 666));
        System.out.println(list);
    }
}
