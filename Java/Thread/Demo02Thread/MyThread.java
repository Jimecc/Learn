package Thread.Demo02Thread;

/**
 * @author Jim
 * @Description
 * @createTime 2022年11月14日
 */
public class MyThread extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("run:"+i);
        }
    }
}
