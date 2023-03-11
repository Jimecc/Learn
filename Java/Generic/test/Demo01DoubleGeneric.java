package Generic.test;

/**
 * @author Jim
 * @Description
 * @createTime 2022年11月09日
 */
public class Demo01DoubleGeneric {

    public static void main(String[] args) {
        DoubleGeneric<Integer,String,Integer> d = new DoubleGeneric<>();
        d.setId(1);
        d.setName("小花");
        d.setAge(18);
        System.out.println(d.getId());
        System.out.println(d.getName());
        System.out.println(d.getAge());
    }
}
