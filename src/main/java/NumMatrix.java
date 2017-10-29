/**
 * Created by 孙亮 on 2017/5/13.
 *
 *  + + + + + * * * . . .
 *  + + + + + * * * . . .
 *  - - - - - / / / . . .
 *  - - - - - / / / . . .
 *  . . . . . . . . . . .
 *
 *  假设上图为原始矩阵，如上所示：'/'为需要求的区域
 *  因此Q('/') = Q('/+-*') - Q('+*') - Q('+-') -Q('+')
 *  设Q('/')的左上角为[r1, c1]，右下角为[r2, c2]
 *  构建新矩阵sumMatrix，让[i,j]位置存储从[0,0]开始到[i,j]的和。
 *  Q('/+-*') = sumMatrix[r2, c2], Q('+*') = sumMatrix[r1-1, c2]
 *  Q('+-') = sumMatrix[r2, c1-1], Q('+') = sumMatrix[r1-1, c1-1]
 */
public class NumMatrix {
    private int[][] matrix;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[0].length; j++){
                int leftCorner = i > 0 && j >0 ? this.matrix[i-1][j-1] : 0;
                int top = j > 0 ? this.matrix[i][j-1] : 0;
                int left = i > 0 ? this.matrix[i-1][j] : 0;

                this.matrix[i][j] = left+top+this.matrix[i][j]-leftCorner;
            }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int left = col1 > 0 ? this.matrix[row2][col1-1] : 0;
        int top = row1 > 0 ? this.matrix[row1-1][col2] : 0;
        int leftCorner = col1 > 0 && row1 > 0 ? this.matrix[row1-1][col1-1] : 0;
        return this.matrix[row2][col2] - left - top + leftCorner;
    }
}
