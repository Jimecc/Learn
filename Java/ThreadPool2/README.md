# 线程池
创建线程的几种方式

- 集成Thread
- 实现Runnable
- 实现Callable(有返回值、可以中断)

# 线程池
`Executors`线程池创建的类<br>
newFixedThreadPool：定长
newWorkThreadPool:工作窃取

```java
    public ThreadPoolExecutor(int corePoolSize, // 核心线程数
                              int maximumPoolSize, // 最大线程数
                              long keepAliveTime, // 空闲时间
                              TimeUnit unit, // 时间单位
                              BlockingQueue<Runnable> workQueue, // 阻塞队列
                              ThreadFactory threadFactory, // 线程工厂（给线程指定名称）
                              RejectedExecutionHandler handler // 拒绝策略
        ) 
```
