class Solution {
    public int[] countBits(int n) {
        int A[] = new int[n+1];
        A[0] = 0;
        String w = "0";
        int count = 0;
        boolean add = false;
        for (int i = 1; i <= n; i++) {
            for (int j = w.length() - 1; j >= 0; j--) {
                if (j == w.length() - 1) {
                    if (w.charAt(j) == '1') {
                        add = true;
                        w = w.substring(0, j) + "0" + w.substring(j + 1);
                        
                    } else w = w.substring(0, j) + "1" + w.substring(j + 1);
                } else {
                    if (add && w.charAt(j) == '1') w = w.substring(0, j) + "0" + w.substring(j + 1);
                    else {
                        if (add) {
                            w = w.substring(0, j) + "1" + w.substring(j + 1);
                            add = false;
                        }
                    } 
                }
            }
            if (add) w = "1" + w;
            System.out.println(w);
            add = false;
            for (int j = w.length() - 1; j >= 0; j--) {
                if (w.charAt(j) == '1') count++;
            }
            A[i] = count;
            count = 0;
        }
        return A;
    }
}