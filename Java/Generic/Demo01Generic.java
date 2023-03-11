package Generic;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Jim
 * @Description Object 的异常
 * @createTime 2022年11月09日
 */
public class Demo01Generic {

    public static void main(String[] args) {
        show01();
    }

    public static void show01(){
        ArrayList list = new ArrayList();
        list.add(01);
        list.add("abc");

        Iterator it = list.iterator();
        while (it.hasNext()){
            Object o = it.next();
            System.out.println(o);
        }
    }
}
