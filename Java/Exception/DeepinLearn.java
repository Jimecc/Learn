//package PureJava.Exception;
//
//import com.sun.tools.javac.util.List;
//
///**
// * @author Jim
// * @Description
// * @createTime 2022年11月12日
// */
//public class DeepinLearn {
//    public static void main(String[] args) {
//        try{
//            int[] arr =  {1,2,3};
//            System.out.println(arr[3]);
//            List<Integer> list = List.of(1,2,3);
//            System.out.println(list.get(3));
//        }catch (IndexOutOfBoundsException e){
//            e.printStackTrace();
//        }
//
//        System.out.println("后续代码");
//        System.out.println(abc());
//
//    }
//
//    public static int abc(){
//        int a=0;
//        if (a==10){
//            return 1;
//        }
//        try {
//            return 10;
//        }catch (Exception e){
//            e.printStackTrace();
//        }
////        finally {
////            return 100;
////        }
//        return 100;
//
//    }
//}
