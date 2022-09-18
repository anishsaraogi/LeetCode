class Solution {
    public boolean isPalindrome(int x) {
        int s=0, t=x;
        while(x>0) {
            int d = x%10;
            s=s*10+d;
            x/=10;
        }
        if (t==s)
            return true;
        else
            return false;
    }
}