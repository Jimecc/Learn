package Generic;

/**
 * @author Jim
 * @Description 定义含有泛型的方法
 * @createTime 2022年11月09日
 *
 * 格式：
 *  修饰符 <泛型> 返回值类型 方法名称（参数列表（使用泛型））{
 *      方法体;
 *  }
 *
 *  含有泛型的方法，在调用方法的时候确定泛型的数据类型，传递什么参数类型，泛型就是什么类型
 */
public class GenericMethod {

    public <M> void method01(M m){
        System.out.println(m);
    }

    public static <E> void method02(E e){
        System.out.println(e);
    }
}
