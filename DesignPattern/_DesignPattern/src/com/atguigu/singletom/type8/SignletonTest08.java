/**
 * @author Jim
 * @Description 采用枚举方式
 * @createTime 2022年08月15日
 */
public class SignletonTest08  {

    public static void main(String[] args) {
        Singleton08 instance1 = Singleton08.INSTANCE;
        Singleton08 instance2 = Singleton08.INSTANCE;
        System.out.println(instance1 == instance2);
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }

}


// 使用枚举可以实现单例模式 推荐
enum Singleton08{

    INSTANCE; // 属性

    public void sayOK(){
        System.out.println("OK");
    }
}
