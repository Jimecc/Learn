package Generic;

/**
 * @author Jim
 * @Description 泛型
 * @createTime 2022年11月09日
 */
public class GenericClass<T> {

    public T name;

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }
}
