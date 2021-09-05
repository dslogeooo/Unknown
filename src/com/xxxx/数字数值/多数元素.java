package com.xxxx.数字数值;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 多数元素 {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i]) >= (len>>1)){
                return map.get(i);
            }
        }
        return 0;
    }
    public int majorityElement2(int[] nums)
    {
        int res = 0;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(count == 0){
                res = nums[i];
                count++;
            }else{
                if(res == nums[i]){
                    count++;
                }else{
                    count--;
                }
            }
        }
        return res;
    }
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    @Test
    public void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);

            int ret = majorityElement(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
