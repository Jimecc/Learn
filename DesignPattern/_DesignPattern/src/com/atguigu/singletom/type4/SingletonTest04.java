/**
 * @author Jim
 * @Description 懒汉式（线程不安全）
 * @createTime 2022年08月15日
 */
public class SingletonTest04 {
    public static void main(String[] args) {
        Singleton04 singleton01 = Singleton04.getInstance();
        Singleton04 singleton02 = Singleton04.getInstance();
        System.out.println( singleton01 == singleton02 );

    }
}

class Singleton04{
    private static Singleton04 instance;

    private Singleton04(){}

    /**
     * 提取一个静态的共有对象，当时用到该方法是，采取创建instance对象
     * // 加一个 synchronized 保证线程安全
     * @return
     */
    public static synchronized Singleton04 getInstance(){
        if(null == instance){
            System.out.println("null");
            instance = new Singleton04();
        }
        System.out.println("Create");
        return instance;
    }

}
