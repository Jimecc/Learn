/**
 * @author Jim
 * @Description 懒汉式（线程不安全）
 * @createTime 2022年08月17日
 */
public class SingletonTest07 {
    public static void main(String[] args) {
        Singleton04 singleton01 = Singleton04.getInstance();
        Singleton04 singleton02 = Singleton04.getInstance();
        System.out.println( singleton01 == singleton02 );

    }
}

class Singleton07{
    private static volatile Singleton07 instance;

    // 构造器私有化
    private Singleton07(){}

    // 写一个静态内部类，该类中有一个私有属性Singleton07
    private  static  class SingletonInstance{
        private static final Singleton07 INSTANCE = new Singleton07();
    }

    /**
     * 提取一个静态的共有对象，加入双重检验，解决了线程安全问题与懒加载
     * 推荐使用
     * @return
     */
    public static synchronized Singleton07 getInstance(){

        System.out.println("Return");
        return SingletonInstance.INSTANCE;
    }

}
