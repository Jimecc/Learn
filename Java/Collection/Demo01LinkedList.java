package Collection;

import java.util.LinkedList;

/**
 * @author Jim
 * @Description
 * @createTime 2022年11月11日
 */
public class Demo01LinkedList {

    public static void main(String[] args) {
        show01();
    }

    private static void show01() {
        LinkedList<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.addFirst("www");
        list.push("http://");
        System.out.println(list);
        System.out.println(list.pop());
        System.out.println(list);
    }
}
