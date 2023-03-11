package Thread.Demo05ThreadSafe.S2synchronizedMethod;

public class Demo {
    public static void main(String[] args) {
        RunnableImpl02 r = new RunnableImpl02();
        Thread t = new Thread(r);
        t.start();
    }
}
