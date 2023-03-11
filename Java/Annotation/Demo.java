package Annotation;

/**
 * @author Jim
 * @version 1.0
 * @since 1.5
 */

public class Demo {

    static int a = 0;
    static int b = 1;
    /**
     * 计算两数的和
     * @param a 整数A
     * @param b 整数B
     * @return 计算两数的和
     */
    @Deprecated
    public static int add(int a,int b){
        return a+b;
    }

    public static int add(int a,int b,int c){
        return a+b+c;
    }

    public static void main(String[] args){
        System.out.println(add(a, b));
        System.out.println(add(1,2,3));
    }
}
