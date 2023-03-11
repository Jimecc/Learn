package Stream;

import java.io.*;

/**
 * 序列化与反序列化
 * 序列化注意事项：
 *      要进行序列化和反序列化的类必须实现Serializable接口，就会给类添加一个标记
 *      当我们对此类进行序列化的时候，就会检测此标记
 *          如果有，则可以进行序列化与反序列化
 *          没有，则抛出NotSerializableException异常
 */
public class Demo06ObjectOutputStream {

    public static void main(String[] args) throws IOException {

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Stream/person.txt"));
        oos.writeObject(new Person(19,"小美女"));
        oos.close();

    }

}
