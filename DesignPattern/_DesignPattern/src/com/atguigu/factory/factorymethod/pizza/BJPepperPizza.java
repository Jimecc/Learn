/**
 * @author Jim
 * @Description 北京胡椒披萨
 * @createTime 2022年08月17日
 */
public class BJPepperPizza extends Pizza {
    @Override
    public void prepare() {
        setName("北京胡椒披萨");
        System.out.println("给北京的胡椒披萨准备原材料");
    }
}
