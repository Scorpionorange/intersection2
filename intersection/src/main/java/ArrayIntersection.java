import java.util.ArrayList;

/**
 * Created by ScorpionOrange on 2016/10/23.
 */
public class ArrayIntersection {
    public static void main(String[] args)
    {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        Solution s = new Solution();
        int[] out = s.intersection(nums1, nums2);

        for(int i : out){
            System.out.print(i + ", ");
        }
    }
}

class Solution{
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */

    public int[] intersection(int[] nums1, int[] nums2){
        // Write your code here
        nums1 = removeRepeatFromArray(nums1);
        nums2 = removeRepeatFromArray(nums2);

        ArrayList<Integer> temp = new ArrayList<Integer>();

        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                if(nums1[i] == nums2[j]){
                    temp.add(nums1[i]);
                }
            }
        }

        int[] output = new int[temp.size()];
        for(int i = 0; i < output.length; i++){
            output[i] = (int)temp.get(i);
        }
        output = removeRepeatFromArray(output);

        return output;
    }

    // 去除数组中重复元素方法：
    // 新建布尔值的判断数组，默认为true；
    // 遍历来源数组，如果第n位与n+1位以及后面的有重复情况，则后面的那位为false；
    // 计算true的数量，新建输出数组；
    // 如果判断数组相应元素为true，则存入输出数组；
    public int[] removeRepeatFromArray(int[] inputArray){

        ArrayList<Integer> temp = new ArrayList<Integer>();

        for(int i = 0; i < inputArray.length; i++){
            boolean isRepeat = true;
            for(int j = i + 1; j < inputArray.length; j++){
                if(inputArray[i] == inputArray[j]){
                    isRepeat = false;
                }
            }
            while(isRepeat){
                temp.add(inputArray[i]);
            }
        }

        int[] output = new int[temp.size()];

        for(int i = 0; i < output.length; i++){
            output[i] = (int)temp.get(i);
        }

        return output;
    }
}
