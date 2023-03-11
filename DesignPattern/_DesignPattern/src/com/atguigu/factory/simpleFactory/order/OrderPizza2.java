import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Jim
 * @Description
 * @createTime 2022年08月16日
 */
public class OrderPizza2 {

    Pizza pizza = null;

    // 构造器
    public OrderPizza2(){
        String orderType = "";
        do{
            orderType = gettype();
            pizza = SimpleFactory.createPizza2(orderType);
            if(null != pizza){
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }else{
                System.out.println("订购Pizza失败");
                break;
            }
        }while(true);
    }


    // 一个屋可以获取用户种类的方法
    private String gettype(){
        try{
            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("input pizza type:");
            String str = strin.readLine();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
