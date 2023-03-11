package Stream;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * java.io.OutputStream：此抽象类是表示苏处字节流的所有的超类
 * 定义了一些子类共性的成员方法
 *      - public void close:关闭次输出流并释放与此流相关的任何系统资源
 *      - public void flush():刷新次输出流并强制任何缓冲的输入字节被写出
 *      - public void write(byte[] b):将b.length字节从指定的字节数组写入此输出流
 *      - public void write(byte[] b,int off,int len):从指定的字节数组写入len字节，从偏移量off开始输出到此输出流
 *      - public abstract void write：将指定的字节输出流；
 *
 * 已知子类：
 *      ByteArrayOutputStream
 *      FileOutputStream
 *      FilterOutputStream
 *      ObjectOutputStream
 *      OutputStrean
 *      PipedOutputStream
 *
 *  java.io.FileOutputStream extends java.io.OutputStream
 *  文件字节输出流:把内存中的数据写入到硬盘文件中
 *
 *  构造方法：
 *      - FileOutputStream(String name) 创建一个向具有指定名称的文件中写入数据的输出文件
 *      - FileOutputStream（File file) 创建一个向指定File对象表示的文件中写入数据的文件输出流
 * 参数：写入数据的目的
 *      String name：目的地是一个文件的路径
 *      File file：目的地是一个文件
 * 构造方法的使用：
 *      1. 创建一个FileOutputStream对象
 *      2. 会根据构造方法中传递的文件/文件路径，创建一个空的文件
 *      3. 会把FileOutputStream对象指向创建好的文件
 * 写入数据的原理（内存 -> 硬盘）
 *      Java程序 --> JVM（JVM虚拟机） --> OS（操作系统） --> OS调用写数据的方法 --> 把数据写入文件中
 *
 * 字节输出流的使用步骤（重点）：
 *      1. 创建一个FileOutputStream对象，构造方法中传递写入数据的目的地
 *      2. 调用FileOutputStream对象中的write方法，把数据写入到文件中
 *      3. 释放资源（使用六会占用一定的内存，使用完毕要把内存清空，提高程序效率）
 *
 */
public class Demo01OutputStream {

    public static void main(String[] args) throws IOException{
        FileOutputStream fos = new FileOutputStream("Stream/a.txt");
        fos.write(97);
        fos.write(9);

        // public void write(byte[] bytes)
            // 如果写入的是 1~127 那么查询的是ASCII 码表
            // 如果写入的是一个字节是负数，那么第一个字节回合第二个字节，两个字节组成一个中文件显示，默认查询（GBK)
        byte[] bytes1 = {65,66,67,69};
        byte[] bytes2 = {-65,-66,-67,68,69};
        fos.write(bytes1);
        fos.write(bytes2);

        fos.write("你好,世界".getBytes());
        for (byte aByte : "你好,世界".getBytes()) {
            System.out.println(aByte);
        }
        fos.close();
    }
}
