/**
 * @author Jim
 * @Description 北京起司披萨
 * @createTime 2022年08月17日
 */
public class BJCheesePizza extends Pizza{
    @Override
    public void prepare() {
        setName("北京奶酪披萨");
        System.out.println("给北京的奶酪披萨准备原材料");
    }
}
