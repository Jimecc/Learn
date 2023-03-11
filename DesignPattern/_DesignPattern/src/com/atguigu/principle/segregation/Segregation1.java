/**
 * @author Jim
 * @Description 接口隔离原则
 * @createTime 2022年08月12日
 */
public class Segregation1 {
    public static void main(String[] args) {
        A a = new A();
        a.depend1(new C());
        a.depend2(new C());
        a.depend3(new C());
        a.depend1(new D());
        a.depend2(new C());
        a.depend3(new C());
    }
}

// A 类通过 Interfa1 使用C类，但是只会用到1、2、3方法
class A{
    public void depend1(Interface1 i){
        i.operation1();
    }
    public void depend2(Interface1 i){
        i.operation2();
    }
    public void depend3(Interface1 i){
        i.operation3();
    }
}

// B 类通过 Interfa1 使用D类，但是只会用到1、4、5方法
class B{
    public void depend1(Interface1 i){
        i.operation1();
    }
    public void depend4(Interface1 i){
        i.operation4();
    }
    public void depend5(Interface1 i){
        i.operation5();
    }
}

interface Interface1{
    void operation1();
    void operation2();
    void operation3();
    void operation4();
    void operation5();
}

class C implements Interface1{

    @Override
    public void operation1() {
        System.out.println("C's Method implements 1");
    }

    @Override
    public void operation2() {
        System.out.println("C's Method implements 2");
    }

    @Override
    public void operation3() {
        System.out.println("C's Method implements 3");
    }

    @Override
    public void operation4() {
        System.out.println("C's Method implements 4");
    }

    @Override
    public void operation5() {
        System.out.println("C's Method implements 5");
    }
}

class D implements Interface1{

    @Override
    public void operation1() {
        System.out.println("D's Method implements 1");
    }

    @Override
    public void operation2() {
        System.out.println("D's Method implements 2");
    }

    @Override
    public void operation3() {
        System.out.println("D's Method implements 3");
    }

    @Override
    public void operation4() {
        System.out.println("D's Method implements 4");
    }

    @Override
    public void operation5() {
        System.out.println("D's Method implements 5");
    }
}
