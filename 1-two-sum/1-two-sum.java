class Solution {
    public int[] twoSum(int[] nums, int target) {
        int firstPos = 0, secondPos = 0, n = nums.length;
        for(int i = 0; i< n-1; i++){
            for(int j = i+1; j<n; j++){
                if(nums[i]+nums[j]==target){
                    firstPos = i;
                    secondPos = j;
                    break;
                }
            }
        }
        int ans[] = {firstPos, secondPos};
        return ans;
    }
}