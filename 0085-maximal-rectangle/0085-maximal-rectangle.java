class Solution {
    public int maximalRectangle(char[][] matrix) {
        int curRow[] = new int[matrix[0].length];
        Arrays.fill(curRow, 0);
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') curRow[j] += 1;
                else curRow[j] = 0;
            }
            int ans = largestHistogram(curRow);
            max = Math.max(max, ans);
        }
        return max;
    }
    public int largestHistogram(int matrix[]) {
        int prev[] = new int[matrix.length];
        int next[] = new int[matrix.length];
        Stack<Integer> s = new Stack<Integer>();
        Stack<Integer> w = new Stack<Integer>();
        int maxAns = 0;
        int j = matrix.length - 1;
        for (int i = 0; i < matrix.length; i++) {
            while (!s.isEmpty() && matrix[s.peek()] >= matrix[i]) s.pop();
            if (s.isEmpty()) prev[i] = -1;
            else prev[i] = s.peek();
            s.push(i);
            
            while (!w.isEmpty() && matrix[w.peek()] >= matrix[j]) w.pop();
            if (w.isEmpty()) next[j] = matrix.length;
            else next[j] = w.peek();
            w.push(j);
            j--;
        }
        for (int i = 0; i < matrix.length; i++) {
            int cur = (next[i] - prev[i] - 1) * matrix[i];
            maxAns = Math.max(maxAns, cur);
        }
        return maxAns;
    }
}