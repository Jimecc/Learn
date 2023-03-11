package Exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Jim
 * @Description
 * @createTime 2022年11月11日
 */
public class Demo01Exception {
    public static void main(String[] args) /*throws ParseException */ {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        Date date;

        // Exception
        {
            try {
                date = sdf.parse("1998-03-03");
                System.out.println(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        // RuntimeException
        int[] arr1 = {1,2,3};
        try {
            System.out.println(arr1[0]);
            System.out.println(arr1[3]);
        }catch (Exception e){
            System.out.println("异常了");
        }


        // Error 内存溢出错误:必须修改源代码，让创建的数组小一点
        int[] arr2 = new int[1024*1024*1024];


    }
}

