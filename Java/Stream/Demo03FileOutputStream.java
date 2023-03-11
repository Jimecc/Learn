package Stream;

import java.io.FileOutputStream;
import java.io.IOException;

public class Demo03FileOutputStream {

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("Stream/b.txt",true);
        for (int i = 0; i < 10; i++) {
            fos.write("你好".getBytes());
            fos.write("\r".getBytes());
        }

        fos.close();
    }

}
