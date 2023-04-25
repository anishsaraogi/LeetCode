class Solution {
    public int minPathSum(int[][] grid) {
        int A[][] = new int[grid.length][grid[0].length];
        for (int i = 1; i <= grid.length; i++) {
            Arrays.fill(A[i-1], 0);
        }
        return pathFinder(0, 0, A, grid);
    }
    public int pathFinder(int i, int j, int A[][], int O[][]) {
        int count = 0;
        if (i >= A.length || j >= A[0].length)
            return 0;
        if (i == A.length - 1 && j == A[0].length - 1) {
            return O[i][j];
        }
        if (A[i][j] != 0) {
            count += A[i][j];
        } else {
            if (i == A.length - 1)
                A[i][j] = O[i][j] + pathFinder(i, j+1, A, O);
            else if (j == A[0].length - 1)
                A[i][j] = O[i][j] + pathFinder(i + 1, j, A, O);
            else {
                int right = pathFinder(i, j+1, A, O);
                int down = pathFinder(i+1, j, A, O);
                A[i][j] = O[i][j] + Math.min(right, down);
            }
            count = A[i][j];
        }
        return count;
    }
}