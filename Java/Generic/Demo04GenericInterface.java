package Generic;

/**
 * @author Jim
 * @Description 泛型接口
 * @createTime 2022年11月09日
 */
public class Demo04GenericInterface {

    public static void main(String[] args) {
        GenericInterface<String> g1 = new GenericInterfaceImpl1<>();
        g1.method("str");

        GenericInterface<Integer> g2 = new GenericInterfaceImpl1<>();
        g2.method(123);

        GenericInterfaceImpl2 g3 = new GenericInterfaceImpl2();
        g3.method("123");
    }
}
