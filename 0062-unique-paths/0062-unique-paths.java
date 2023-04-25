class Solution {
    public int uniquePaths(int m, int n) {
        int A[][] = new int[m][n];
        for (int i = 1; i <= m; i++) {
            Arrays.fill(A[i-1], 0);
        }
        return pathFinder(0, 0, A);
    }
    public int pathFinder(int i, int j, int A[][]) {
        int count = 0;
        if (i >= A.length || j >= A[0].length)
            return count;
        if (i == A.length - 1 && j == A[0].length - 1) {
            return 1;
        }
        if (A[i][j] != 0) {
            count += A[i][j];
        } else {
            A[i][j] = pathFinder(i+1, j, A) + pathFinder(i, j+1, A);
            count = A[i][j];
        }
        return count;
    }
}