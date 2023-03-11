package Thread.Demo05ThreadSafe.S3Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadLock implements Runnable{

    private int ticket = 100;

    @Override
    public void run() {

        Lock l = new ReentrantLock();
        while (ticket > 0) {
            l.lock();
            if (ticket > 0) {
                // 票存在
                System.out.println(Thread.currentThread().getName() + "正在卖第 " + ticket + " 张票；");
                ticket--;
            }
            l.unlock();
        }
    }
}
