package com.xxxx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class findtwo {
    public static void main(String[] args) {
        List list=new ArrayList();
        for(int i=1;i<=100;i++){
            list.add(i);
        }
        int[] source=new int[98];
        for(int i=0;i<source.length;i++){
            int position=(int)(Math.random()*list.size());
//            System.out.println(position);
            source[i]=(Integer)list.get(position);
            list.remove(position);
        }
// for(int i=0;i<source.length;i++){
// System.out.println(source[i]);
// }
//到这里source中放入了1～100随机的98个数字并且打乱了顺序
        //方法1
        test(source);




        int[]nums1 = new int[100];
        int[]nums2 = new int[98];
        list = new ArrayList();
        for(int i=1;i<100;i++){
            nums1[i] = i;
            list.add(i);
        }
        for(int i=0;i<source.length;i++){
            int position=(int)(Math.random()*list.size());
//            System.out.println(position);
            nums2[i]=(Integer)list.get(position);
            list.remove(position);
        }
        //方法2
        findMissNum(nums2);

    }

    public static int[] findMissNum(int[] array) {
        if(array==null || array.length==0) {
            return null;
        }

        int len = array.length;
        int miss = 100-len;
        int[] res = new int[miss];


        int i=1;
        int k=0;
        for(int j=0; j<len-1; j++) {
            int dif = array[j+1] - array[j];
            if(dif==1) {
                i++;
                continue;
            } else {
                while((dif--)!=1) {
                    i++;
                    res[k++] = i;
                }
                i++;
            }
        }

        //末尾的数被抽出了
        int n=(miss-k);
        int m=100-n+1;

        for(;n>0;n--) {
            res[k++] = m++;
        }

        return res;
    }

    public static void test(int[] source){
        HashMap map=new HashMap();
        for(int i=0;i<source.length;i++){
            map.put(source[i], source[i]);
        }
        for(int i=1;i<=100;i++){
            if(!map.containsKey(i)){
                System.out.println(i+"不在数组中");
            }
        }
    }
}