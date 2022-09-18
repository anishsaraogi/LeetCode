class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int mid = n/2;
        int ll = 0;
        int ul = n-1;
        while(ll<=ul){
            if(nums[mid]>target){
                ul = mid-1;
            } else if(nums[mid]<target){
                ll = mid+1;
            } else if(nums[mid]==target){
                return mid;
            }
            mid = (ul+ll)/2;
        }
        return -1;
    }
}