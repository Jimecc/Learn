package Generic;

/**
 * @author Jim
 * @Description
 * @createTime 2022年11月09日
 */
public class Demo02GenericClass {

    public static void main(String[] args) {
        GenericClass<Integer> g = new GenericClass<>();
        g.setName(123);
        System.out.println(g.getName());
    }



}
