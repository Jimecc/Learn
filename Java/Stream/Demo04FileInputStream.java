package Stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Demo04FileInputStream {

    public static void main(String[] args) throws IOException {
         File file = new File("Stream/c.txt");
        FileInputStream fis = new FileInputStream(file);
//        int len1 = 0;
//        while ((len1 = fis.read() ) != -1 ) {
//            System.out.println(len1);
//        }
//
//        byte[] bytes2 = new byte[2];
//        int len2 = fis.read(bytes2);
//        System.out.println(len2);
//        System.out.println(Arrays.toString(bytes2));
//        System.out.println(new String(bytes2));

        byte[] bytes3 = new byte[1024];
        int len3 = 0;
        while((len3 = fis.read(bytes3)) != -1 ){
            System.out.println(new String(bytes3,0 ,len3));
        }
        fis.close();
    }
}
