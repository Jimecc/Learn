package Generic;

/**
 * @author Jim
 * @Description
 * @createTime 2022年11月09日
 */
public class Demo03GenericMethod {

    public static void main(String[] args) {
        GenericMethod g = new GenericMethod();
        g.method01("123");
        g.method01(123);

        g.method02("Tree");
        GenericMethod.method02(123);
        GenericMethod.method02("String");
    }
}
