/**
 * @author Jim
 * @Description 接口隔离原则，将Interface1分成三个接口
 * @createTime 2022年08月12日
 */

public class Segregation2 {
    public static void main(String[] args) {
        A2 a = new A2();
        a.depend1(new C2());
        a.depend2(new C2());
        a.depend3(new C2());
    }
}


interface Interface2{
    void operation1();
}


interface Interface3{
    void operation2();
    void operation3();
}

interface Interface4{
    void operation4();
    void operation5();
}


// A 类通过 Interfa1 使用C类，但是只会用到1、2、3方法
class A2{
    public void depend1(Interface2 i){
        i.operation1();
    }
    public void depend2(Interface3 i){
        i.operation2();
    }
    public void depend3(Interface3 i){
        i.operation3();
    }
}

// B 类通过 Interfa1 使用D类，但是只会用到1、4、5方法
class B2{
    public void depend1(Interface2 i){
        i.operation1();
    }
    public void depend4(Interface4 i){
        i.operation4();
    }
    public void depend5(Interface4 i){
        i.operation5();
    }
}


class C2 implements Interface2,Interface3{

    @Override
    public void operation1() {
        System.out.println("C's Method1 implements 1");
    }

    @Override
    public void operation2() {
        System.out.println("C's Method2 implements 2");
    }

    @Override
    public void operation3() {
        System.out.println("C's Method3 implements 2");
    }
}

class D2 implements Interface2,Interface4{

    @Override
    public void operation1() {
        System.out.println("D's Method1 implements 1");
    }

    @Override
    public void operation4() {
        System.out.println("D's Method2 implements 3");
    }

    @Override
    public void operation5() {
        System.out.println("D's Method3 implements 3");
    }
}
