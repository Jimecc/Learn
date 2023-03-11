package Thread;

public class Demo {

    public static void main(String[] args) {
//        MyThread mt = new MyThread();
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1000);
                System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

//        mt.start();
//        mt.run();
    }
}