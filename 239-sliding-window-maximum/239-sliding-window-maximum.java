class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new LinkedList<>();
        int ans[] = new int[n-k+1];
        if(n<=1) 
            return nums;
        int i = 0;
        for(; i < n; i++) {
            if(i<k) {
                while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i])
                    dq.removeLast();
                dq.addLast(i);
            } else {
                ans[i-k] = nums[dq.peekFirst()];
                while(!dq.isEmpty() && dq.peekFirst() <= i-k)
                    dq.removeFirst();
                while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i])
                    dq.removeLast();
                dq.addLast(i);
            }
        }
        ans[i-k] = nums[dq.peekFirst()];
        return ans;
    }
}