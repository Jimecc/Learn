package Stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo05CopyImg {
    public static void main(String[] args) throws IOException {
        long sta = System.currentTimeMillis();
        FileInputStream fileInputStream = new FileInputStream("Stream/a.png");
        FileOutputStream fileOutputStream = new FileOutputStream("Stream/b.png");

        int len = 0;

//        byte[] b = new byte[1024];
//        while((len = fileInputStream.read(b))!=-1){
//            fileOutputStream.write(b,0,len);
//        }
        while((len = fileInputStream.read())!=-1){
            fileOutputStream.write(len);
        }

        fileInputStream.close();
        fileOutputStream.close();
        long end = System.currentTimeMillis();
        System.out.println("总共耗时："+(end - sta) +"毫秒");
    }
}
