package Thread.Demo06WaitNotify;

public class Demo01WaitAndNotify {

    public static void main(String[] args) {
        Object obj = new Object();

        new Thread(){
            @Override
              public void run(){
                synchronized (obj){
                    System.out.println("告诉老板要做包子");
                    try{
                        obj.wait();
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    System.out.println("好了，开始吃了");
                }
              }
        }.start();

        new Thread(){
            @Override
            public void run(){
                synchronized (obj){

                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("包子做好了");
                    obj.notify();

                }
            }
        }.start();
    }
}
