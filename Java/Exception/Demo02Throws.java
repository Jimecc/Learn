package Exception;

import java.io.IOException;

/**
 * @author Jim
 * @Description
 * @createTime 2022年11月11日
 */
public class Demo02Throws {

    public static void main(String[] args) {


    }

    public static void method(String filename) throws IOException {
        if(!filename.equals("/home/jim/xxx")){
            throw new IOException("文件后缀名错误");
        }
    }
}
