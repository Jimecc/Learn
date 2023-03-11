package Thread.Demo05ThreadSafe.S3Lock;

public class Demo {
    public static void main(String[] args) {
        ThreadLock r = new ThreadLock();
        Thread t = new Thread(r);
        t.start();
    }
}
