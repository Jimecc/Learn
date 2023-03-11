package Lambda.Demo04Calculator;

public class Demo {

    public static void main(String[] args) {
        invokeCalc(10, 21, new Calculator() {
            @Override
            public int calc(int a, int b) {
                return a+b;
            }
        });

        invokeCalc(10,11,(int a,int b)->{
            return a+b;
        });
    }

    private static void invokeCalc(int a,int b,Calculator calculator){
        int result = calculator.calc(a,b);
        System.out.println(result);
    }
}
