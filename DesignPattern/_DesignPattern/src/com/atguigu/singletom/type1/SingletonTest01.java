/**
 * @author Jim
 * @Description 单例模式 饿汉式 静态变量
 * @createTime 2022年08月15日
 */
public class SingletonTest01 {


    public static void main(String[] args) {
        // 两个 instance 相等
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println( instance1 == instance2 );
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());

    }
}

/**
 * 饿汉式 静态变量
 */


class Singleton{
    // 1. 创建一个私有化构造方法
    private Singleton(){

    }

    // 2. 本类内部创建对象实例
    private final static Singleton instance = new Singleton();

    // 3. 对外提供一个共有的静态方法返回实例对象
    public static Singleton getInstance(){
        return instance;
    }
}