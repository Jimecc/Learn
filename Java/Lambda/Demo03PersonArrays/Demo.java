package Lambda.Demo03PersonArrays;

import java.util.Arrays;
import java.util.Comparator;

public class Demo {

    public static void main(String[] args) {

        Person[] arr = {
                new Person("刘岩",19),
                new Person("张三",17),
                new Person("迪丽热巴",22)
        };

//        Arrays.sort(arr,new Comparator<Person>(){
//
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.getAge() - o2.getAge();
//            }
//        });

        Arrays.sort(arr,
                (Person o1,Person o2)->{
                    return o1.getAge() - o2.getAge();
                }
        );

        for (Person person : arr) {
            System.out.println(person.toString());
        }
    }
}
