package Thread.Demo04Runable;

public class RunnableImpl implements Runnable{
    @Override
    public void run() {
        for (int j = 0; j < 20; j++) {
            System.out.println(Thread.currentThread().getName()+" ----> " +j);
        }
    }
}
