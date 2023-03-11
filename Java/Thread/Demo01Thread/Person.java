package Thread.Demo01Thread;

/**
 * @author Jim
 * @Description
 * @createTime 2022年11月13日
 */
public class Person {

    String name;

    public void run(){
        for (int i = 0; i < 20; i++) {
            System.out.println(name+i);
        }
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }
}
