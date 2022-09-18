class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums11[] = new int[m];
        for(int i = 0; i< m ; i++)
            nums11[i] = nums1[i];
        int i = 0, j = 0, k = 0;
        while(i<m || j<n || k<(m+n)){
            if(i==m){
                for(int w = j; w<n; w++){
                    nums1[k++] = nums2[w];
                }
                j = n;
            }else if(j==n){
                for(int w = i; w<m; w++){
                    nums1[k++] = nums11[w];
                }
                i = m;
            }else if(nums11[i]<nums2[j]){
                nums1[k] = nums11[i];
                i++;
            } else {
                nums1[k] = nums2[j];
                j++;
            }
            k++;
        }
    }
}