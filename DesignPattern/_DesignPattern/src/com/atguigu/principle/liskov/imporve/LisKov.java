package imporve;

/**
 * @author Jim
 * @Description 里氏替换原则
 * @createTime 2022年08月12日
 */
public class LisKov {

    public static void main(String[] args) {
        liskovA a = new liskovA();
        System.out.println("11-3="+a.func1(11,3));
        System.out.println("8-3="+a.func1(8,3));

        System.out.println("----------------------------------");
        liskovB b = new liskovB();
        System.out.println("11-3="+b.func1(11,3));
        System.out.println("1-8="+b.func1(1,8));
        System.out.println("11+3+9="+b.func2(11,3));

        System.out.println("11-3="+b.func3(11,3));

    }
}

class base{

}

class liskovA extends base{
    public int func1(int n1,int n2){
        return n1 - n2;
    }
}

class liskovB extends base{

    private liskovA a = new liskovA();

    public int func1(int n1, int n2) {
        return n1 + n1;
    }

    public int func2(int a,int b){
        return func1(a,b)+9;
    }

    public int func3(int a,int b){
        return this.a.func1(a,b);
    }
}