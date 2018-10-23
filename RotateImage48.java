class Solution {
    public void rotate(int[][] matrix) {
        int N = matrix.length;
        for (int offset = 0; offset <= N / 2; ++offset) { //offset stands for the layer (circile)
            for (int i = offset; i < N - offset - 1; ++i) {
                int t = matrix[offset][i];
                matrix[offset][i] = matrix[N - 1 - i][offset];
                matrix[N - 1 - i][offset] = matrix[N - 1 - offset][N - 1 - i];
                matrix[N - 1 - offset][N - 1 - i] = matrix[i][N - 1 - offset];
                matrix[i][N - 1 - offset] = t;
            }
        }
    }
}