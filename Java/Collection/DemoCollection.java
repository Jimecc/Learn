package Collection;

import java.util.*;
//import org.apache.commons.codec.digest.DigestUtils;
/**
 * @author Jim
 * @Description
 * @createTime 2022年11月08日
 */
public class DemoCollection {
    public static void main(String[] args) {
        Object o = new Object();
//        Vector<String> v = new Vector<>();
//        ArrayList<String> a = new ArrayList<>();
//        LinkedList<String> l2 = new LinkedList<>();
//
//        TreeSet<String> t = new TreeSet<>();
//        HashSet<String> h = new HashSet<>();
//        LinkedHashSet<String> l = new LinkedHashSet<>();
        char[] c = {'a','b','c','d','e','f','g','h','i','j','k'};
        String s1 = "abcd1"; //
        String s2 = "abcd2";
        System.out.println(hashCode(s1));
        System.out.println(hashCode(s2));
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
//        System.out.println(DigestUtils.md5Hex("1"));

//        int i=1;
//        while (true) {
//            String s2 = getRandomString();
//            System.out.println("I : "+i+"  Length : " + s2.length()+"\tS1 : "+hashCode(c)+"\tS2 : "+hashCode(s2)+"S2 : "+s2);
//            i++;
////            System.out.println(hashCode(s1));
//            if(hashCode( c ) == hashCode( s2 )){
//                System.out.println(s2);
//                break;
//            }
//        }
    }

    private static int hashCode(String a){
        char[] c = a.toCharArray();
        int num = 0;
        for (int x = 0;x<c.length;x++){
            num = 31*num+c[x];
        }
        return num;
    }

    private static int hashCode(char[] a){
        int num = 0;
        for (int x = 0;x<a.length;x++){
            num = 31*num+a[x];
        }
        return num;
    }

    public static String getRandomString(){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789`~！@#￥%……&*（）——+，。、《》？；'：【】、「」|\"";
        Random random1=new Random();
        Random random2=new Random();
        int length = random2.nextInt(50)+1;
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random1.nextInt(94);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
