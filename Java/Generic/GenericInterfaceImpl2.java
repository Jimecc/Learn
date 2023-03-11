package Generic;

/**
 * @author Jim
 * @Description
 * @createTime 2022年11月09日
 */
public class GenericInterfaceImpl2 implements GenericInterface<String>{
    @Override
    public void method(String s) {
        System.out.println(s);
    }
}
