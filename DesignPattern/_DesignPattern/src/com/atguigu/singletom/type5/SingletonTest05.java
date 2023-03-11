/**
 * @author Jim
 * @Description 懒汉式（线程不安全）
 * @createTime 2022年08月15日
 */
public class SingletonTest05 {
    public static void main(String[] args) {
        Singleton04 singleton01 = Singleton04.getInstance();
        Singleton04 singleton02 = Singleton04.getInstance();
        System.out.println( singleton01 == singleton02 );

    }
}

class Singleton05{
    private static Singleton05 instance;

    private Singleton05(){}

    /**
     * 提取一个静态的共有对象，加入双重检验，解决了线程安全问题与懒加载
     * 推荐使用
     * @return
     */
    public static synchronized Singleton05 getInstance(){
        if(null == instance){
            synchronized (Singleton05.class) {
                System.out.println("null");
                instance = new Singleton05();
            }
        }
        System.out.println("Create");
        return instance;
    }

}
