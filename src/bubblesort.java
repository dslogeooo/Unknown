public class bubblesort {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,9,8,6};
    }
    public void bubblesort(int[] nums){
        int len = nums.length;
        for(int end = len-1;end>0;end--){
            for(int begin = 1;begin<=end;begin++){
                if(nums[begin-1]>nums[begin]){
                    swap(nums,begin-1,begin);
                }
            }
        }

    }
    public void swap(int[] nums,int begin,int end){
        int temp = nums[begin];
        nums[begin] = nums[end];
        nums[end] = temp;
    }
}
