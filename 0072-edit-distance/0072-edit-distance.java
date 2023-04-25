class Solution {
    public int minDistance(String word1, String word2) {
        int A[][] = new int[word2.length() + 1][word1.length() + 1];
        
        for (int i = 0; i <= word2.length(); i++) A[i][0] = i;
        for (int i = 0; i <= word1.length(); i++) A[0][i] = i;
        
        for (int i = 1; i <= word2.length(); i++) {
            for (int j = 1; j <= word1.length(); j++) {
                if (word1.charAt(j-1) == word2.charAt(i-1)) A[i][j] = A[i-1][j-1];
                else {
                    A[i][j] = 1 + Math.min(Math.min(A[i-1][j], A[i-1][j-1]), A[i][j-1]);
                }
            }
        }
        return A[word2.length()][word1.length()];
        
    }
}