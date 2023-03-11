package Exception;

/**
 * @author Jim
 * @Description
 * @createTime 2022年11月13日
 */
public class Demo04ExtendsException {


    public static void main(String[] args) {

        try {
            a();
        } catch (ExtendsException e) {
            e.printStackTrace();
        }
    }


    public static void a() throws ExtendsException {
        int a = 0;
        if (a==0){
            throw new ExtendsException("报错了");
        }
    }
}
