package LeetCode;

public class Demo {

    public static void main(String[] args) {
        int[] ints = {1,2,5,7};

        System.out.println(
                Solution.twoSum(ints , 12)
        );
    }
}


class Solution{
    public static int[] twoSum(int[] nums,int target){
        int i1 = 0;
        int i2 = i1;
        int[] result = new int[2];

        for (i1 = 0; i1 < nums.length; i1++) {
            for (i2 = i1; i2 < nums.length; i2++) {
                if(nums[i1] + nums[i2] == target){
                    result[0] = i1;
                    result[1] = i2;
                }
            }
        }

        return result;
    }
}
