/**
 * @author Jim
 * @Description 相当于一个客户端，发出订阅
 * @createTime 2022年08月16日
 */


/**
 * 分析：修改代码可以接受，但是如果我们在其它的地方也有创建Pizza的代码，就意味
 * 着，也需要修改，而创建Pizza的代码，往往有多处。
 *
 * 思路：把创建pizza对象封装到一个类中，这样我们有新的Pizza种类时只需要修改该
 * 类就可，其它有创建到Pizza对象的代码就不需要修改了.-＞简单工厂模式
 */
public class PizzaStore  {
    public static void main(String[] args) {
//        new OrderPizza();

        // 使用简单工厂模式
        new OrderPizza(new SimpleFactory());
        System.out.println("～～退出程序～～");



    }
}
