package Thread.Demo05ThreadSafe.S2synchronizedMethod;

public class RunnableImpl02 implements Runnable{

    private int ticket = 100;



    @Override
    public synchronized void run() {

        while (true) {
            if (ticket > 0) {
                // 票存在
                System.out.println(Thread.currentThread().getName() + "正在卖第 " + ticket + " 张票；");
                ticket--;
            }
            else{
                    break;
            }
        }
    }
}
