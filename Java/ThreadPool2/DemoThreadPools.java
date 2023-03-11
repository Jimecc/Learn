package ThreadPool2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Jim
 * @Description 线程池学习
 * @createTime 2022年11月25日
 */
public class DemoThreadPools {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,10,);
    }

}
