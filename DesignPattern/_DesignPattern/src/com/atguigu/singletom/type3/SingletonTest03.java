/**
 * @author Jim
 * @Description 懒汉式（线程不安全）
 * @createTime 2022年08月15日
 */
public class SingletonTest03 {
    public static void main(String[] args) {
        Singleton03 singleton01 = Singleton03.getInstance();
        Singleton03 singleton02 = Singleton03.getInstance();
        System.out.println( singleton01 == singleton02 );

    }
}

class Singleton03{
    private static Singleton03 instance;

    private Singleton03(){}

    /**
     * 提取一个静态的共有对象，当时用到该方法是，采取创建instance对象
     *
     * @return
     */
    public static Singleton03 getInstance(){
        if(null == instance){
            System.out.println("null");
            instance = new Singleton03();
        }
        System.out.println("Create");
        return instance;
    }

}
