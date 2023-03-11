package Collection;

import java.util.*;


/**
 * @author Jim
 * @Description 迭代器
 * @createTime 2022年11月09日
 *
 *
 * 迭代，即
 */
public class DemoIteratorDDQ {
    public static void main(String[] args) {
        Collection<String> arr = new ArrayList<>();
        arr.add("123");arr.add("234");arr.add("345");
        arr.add("456");arr.add("567");arr.add("678");
        Iterator<String> itarr = arr.iterator();
        while(true){
            if(itarr.hasNext()) {
                System.out.print(itarr.next()+" ");
            }else{
                break;
            }
        }
        System.out.println();
        //
        // ArrayList
        ArrayList<String> list = new ArrayList<String>();
        list.add("123");list.add("234");list.add("345");
        list.add("456");list.add("567");list.add("678");
        Iterator<String> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                System.out.print(it.next()+" ");
            }else{
                break;
            }
        }

        System.out.println();

        Set<String> set = new HashSet<>();
        set.add("123");set.add("234");set.add("345");
        set.add("456");set.add("567");set.add("678");
        Iterator itset = set.iterator();
        while(true){
            if(itset.hasNext()){
                System.out.print(itset.next()+" ");
            }else{
                break;
            }
        }
    }

}
