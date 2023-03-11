package Thread.Demo05ThreadSafe.S1synchronizedCodeBlock;


// 模拟买票，创建三个线程同时买票
public class Demo {
    public static void main(String[] args) {

        RunnableImpl02 r = new RunnableImpl02();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);

        t1.start();
        t2.start();
        t3.start();
    }
}
