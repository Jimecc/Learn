package Reflect;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jim
 * @Description
 * @createTime 2022年11月24日
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String name;
    private int age;

    public int a;
    protected int b;
    int c;
    private int d;

    public void eat(){
        System.out.println("eat1");
    }
    public void eat(String str){
        System.out.println("eat"+str);
    }

    public String eat2(String str){
        return "吃了"+str;
    }

}
