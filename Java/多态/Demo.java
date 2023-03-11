package 多态;

/**
 * @author Jim
 * @Description
 * @createTime 2022年11月11日
 */
public class Demo {

    public static void main(String[] args) {
        Fu fu = new Zi();
        fu.methodFu();


        Zi zi = new Zi();
        zi.methodFu();
        zi.methodZI();
    }
}
