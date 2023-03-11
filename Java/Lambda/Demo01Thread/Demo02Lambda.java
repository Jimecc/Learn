package Lambda.Demo01Thread;

public class Demo02Lambda {

    public static void main(String[] args) {

        // 匿名对象
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("新线程被创建了");
            }
        }).start();

        // Lambda表达式
        new Thread(() -> {
            System.out.println("新线程被创建了");
        }).start();
    }
}
