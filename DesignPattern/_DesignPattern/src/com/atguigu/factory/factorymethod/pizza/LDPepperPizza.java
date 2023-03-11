/**
 * @author Jim
 * @Description 伦敦胡椒披萨
 * @createTime 2022年08月17日
 */
public class LDPepperPizza extends Pizza{
    @Override
    public void prepare() {
        setName("伦敦胡椒披萨");
        System.out.println("给伦敦胡椒披萨准备原材料");
    }
}
