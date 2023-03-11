package Integer;

/**
 * @author Jim
 * @Description Integer 自动装箱
 * @createTime 2022年11月07日
 */
public class Demo01Integer {

    public static void main(String[] args) {
        // 装箱
        String str = "1234";
        Integer a = new Integer(1);
        Integer b = new Integer("2");
        Integer c = 3;
        Integer d = new Integer(str);
        System.out.println(a+b+c+d);

        Integer a1 = Integer.valueOf(1);
        Integer a2 = Integer.valueOf("2");
        System.out.println(a1 + a2);

        //拆箱
        int i1 = a1.intValue();
        int i2 = a2.intValue();
        System.out.println(i1+i2);

    }
}
