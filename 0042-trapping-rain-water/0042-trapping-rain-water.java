class Solution {
    public int trap(int[] height) {
        int maxl = 0;
        int maxr = 0;
        int ans = 0;
        int l[] = new int[height.length];
        int r[] = new int[height.length];
        for (int i = 0, j = height.length - 1; i < height.length; i++, j--) {
            maxl = Math.max(maxl, height[i]);
            l[i] = maxl;
            maxr = Math.max(maxr, height[j]);
            r[j] = maxr;
        }
        for (int i = 0; i < height.length; i++) {
            ans += Math.min(l[i], r[i]) > height[i] ? Math.min(l[i], r[i]) - height[i] : 0;
        }
        return ans;
    }
}