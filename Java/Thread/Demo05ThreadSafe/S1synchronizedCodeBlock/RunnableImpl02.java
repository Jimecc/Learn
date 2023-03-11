package Thread.Demo05ThreadSafe.S1synchronizedCodeBlock;

public class RunnableImpl02 implements Runnable{


    private int ticket = 100;

    @Override
    public void run() {
//        try {
//            Thread.sleep(110);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Object obj = new Object();
            while (true) {
                synchronized(obj) {
                    if (ticket > 0) {

                    // 票存在
                    System.out.println(Thread.currentThread().getName() + "正在卖第 " + ticket + " 张票；");
                    ticket--;
                }else{
                        break;
                    }
            }
        }

    }
}
