package Exception;

/**
 * @author Jim
 * @Description throw关键字
 * @createTime 2022年11月11日
 */
public class Demo02Throw {

    public static void main(String[] args) {
        int[] arr = new int[0];
        getElement(arr,2);
    }

    public static int getElement(int[] arr,int index){
        if(arr == null){
            // 抛出越界警告，告诉方法的调用者”传递的索引超出了数组的适用范围“
            throw new NullPointerException("空指针异常" );
        }
        if(index<0 || index>arr.length - 1){
            throw new ArrayIndexOutOfBoundsException("索引越界异常");
        }
        System.out.println("1234");
        return arr[index];

    }
}
