package Generic;

/**
 * @author Jim
 * @Description 含有泛型的接口的第一种使用方式
 * @createTime 2022年11月09日
 */
public class GenericInterfaceImpl1<T> implements GenericInterface<T>{
    @Override
    public void method(T t) {
        System.out.println(t);
    }
}
