package Lambda.Demo03PersonArrays;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String name;
    private int age;

    @Override
    public String toString(){
        return name+" 今年 " + age +" 岁;";
    }

}
