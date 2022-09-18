class Solution {
    public int maxProfit(int[] prices) {
        int max = 0, diff, low=prices[0];
        for(int i = 1; i<prices.length; i++){
            if(prices[i]<low)
                low = prices[i];
            else{
                diff = prices[i] - low;
                if(diff>max)
                    max = diff;
            }
        }
        return max;
    }
}