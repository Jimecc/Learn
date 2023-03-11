package Thread;

public class MyThread extends Thread{

    @Override
    public void run() {

        Thread t = Thread.currentThread();
        System.out.println(t.getName());

        String name = getName();
        System.out.println(name);
    }
}
