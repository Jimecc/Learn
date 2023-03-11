package 多态;

/**
 * @author Jim
 * @Description
 * @createTime 2022年11月11日
 */
public class Zi implements Fu{
    @Override
    public void methodFu() {
        System.out.println("父类方法");
    }

    public void methodZI(){
        System.out.println("子类特有方法");
    }
}
