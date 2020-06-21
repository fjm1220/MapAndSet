package 面试题;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
public class Solution {
    //法一：放到Map中遍历
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            Integer value = map.get(nums[i]);
            if(value == null){
                map.put(nums[i],1);
            }
            else{
                map.put(nums[i],value+1);
            }
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return -1;
    }
    //方法二：异或
    //a^b^b=a
    public int singleNumber2(int[] nums) {
        int ret = 0;
        for(int i = 0;i < nums.length;i++){
            ret = ret^nums[i];
        }
        return ret;
    }
}
