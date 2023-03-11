package Lambda.Demo02CookTest;

public class Demo {

    public static void main(String[] args) {
        // 调用invokeCook方法，参数是cook接口，传递Cook接口的匿名内部类对象
        invokeCook(new Cook() {
            @Override
            public void makeFood() {
                System.out.println("吃饭了");
            }
        });

        // 使用Lambda表达式，简化几名内部类的读写
        invokeCook(()->{
            System.out.println("干饭了");
        });

    }

    // 定义一个方法，参数传递cook接口，方法内部调用Cook接口中的方法makeFood
    public static void invokeCook(Cook cook){
        cook.makeFood();
    }
}
