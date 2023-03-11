/**
 * @author Jim
 * @Description 简单工厂模式
 * @createTime 2022年08月16日
 */
public class SimpleFactory {

    // 根据OrderType返回一个Pizza实例
    public Pizza createPizza(String orderType){
        Pizza pizza = null;
        System.out.println("使用简单工厂模式创建Pizza");
        if("greek".equals(orderType)){
            pizza = new GreekPizza();
            pizza.setName("希腊披萨");

        }else if("cheese".equals(orderType)){
            pizza = new CheesePizza();
            pizza.setName("奶酪披萨");
        }

        return pizza;
    }



    // 根据OrderType返回一个Pizza实例
    public static Pizza createPizza2(String orderType){
        Pizza pizza = null;
        System.out.println("使用简单工厂模式创建Pizza");
        if("greek".equals(orderType)){
            pizza = new GreekPizza();
            pizza.setName("希腊披萨");

        }else if("cheese".equals(orderType)){
            pizza = new CheesePizza();
            pizza.setName("奶酪披萨");
        }

        return pizza;
    }
}
