/**
 * @author Jim
 * @Description
 * @createTime 2022年08月13日
 */
public class TestSuper {
    public static void main(String[] args) {
        Bx b = new Bx();
        b.abc();
        b.su();
    }
}

abstract class AbstractClass{
    public abstract void abxxxc();
}

class ExtendAbstractClass extends AbstractClass{

    @Override
    public void abxxxc() {
        System.out.println("xzxx");
    }
}

class Ax{
    public void abc(){
        System.out.println("Class A");
    }
}

class Bx extends Ax{

    @Override
    public void abc() {
        System.out.println("Class B");
    }
    
    public void su(){
        super.abc();
    }
}

class Cx extends Bx{
    public void cc(){
        super.abc();
    }


}

interface IABC{
    public void aaa();
}