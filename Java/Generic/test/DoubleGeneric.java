package Generic.test;

/**
 * @author Jim
 * @Description 双泛型，并且单独使用
 * @createTime 2022年11月09日
 */
public class DoubleGeneric<I,N,A> {


    private I id;
    private N name;
    private A age;

    public I getId() {
        return id;
    }

    public void setId(I id) {
        this.id = id;
    }

    public N getName() {
        return name;
    }

    public void setName(N name) {
        this.name = name;
    }

    public A getAge() {
        return age;
    }

    public void setAge(A age) {
        this.age = age;
    }
}
