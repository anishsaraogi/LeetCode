class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int A[][] = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 1; i <= obstacleGrid.length; i++) {
            Arrays.fill(A[i-1], 0);
        }
        return pathFinder(0, 0, A, obstacleGrid);
    }
    public int pathFinder(int i, int j, int A[][], int O[][]) {
        int count = 0;
        if (i >= A.length || j >= A[0].length || O[i][j] == 1)
            return 0;
        if (i == A.length - 1 && j == A[0].length - 1) {
            return 1;
        }
        if (A[i][j] != 0) {
            count += A[i][j];
        } else {
            A[i][j] = pathFinder(i+1, j, A, O) + pathFinder(i, j+1, A, O);
            count = A[i][j];
        }
        return count;
    }
}