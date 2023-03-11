package Annotation;

/**
 * @author Jim
 * @Description
 * @createTime 2022年11月24日
 */
//@MyAnno(1) // 有且仅有一个value属性
//@MyAnno(value=1,str="123",per=Person.p1,anno=@MyAnno2,strArr="abc") // 集合中仅有一个元素
@MyAnno(value=1,str="123",per=Person.p1,anno=@MyAnno2,strArr={"abc","123"}) // 集合中有多个元素
@MyAnno3
public class Demo2 {

    public static void main(String[] args) {

    }
}
