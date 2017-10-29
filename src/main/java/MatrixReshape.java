/**
 * 矩阵reshape是将矩阵重新组织的方法，输入一个二位数组，输入重新组织后的行(r)与列(c)的个数
 * Created by 孙亮 on 2017/5/5.
 */
public class MatrixReshape {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        if(row == 0) return nums;
        int column = nums[0].length;
        if( r<=0 || c<=0 || row*column != r*c) return nums;

        int[][] result = new int[r][c];
        int ii=0, jj = 0;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                result[i][j] = nums[ii][jj];
                jj ++;
                if(jj >= column) {
                    ii ++;
                    jj = 0;
                }
            }
        }
        return result;
    }

    public int[][] matrixReshape_2(int[][] nums, int r, int c) {
        int row = nums.length;
        if(row == 0) return nums;
        int column = nums[0].length;
        if( r<=0 || c<=0 || row*column != r*c) return nums;

        int[][] result = new int[r][c];
        int length = r*c;
        for(int i = 0; i < length; i++) {
            result[i/c][i%c] = nums[i/column][i%column]; // 反应出了矩阵坐标与矩阵之间的关系
        }
        return result;
    }

    public static void main(String[] args) {
        MatrixReshape matrixReshap = new MatrixReshape();
        int[][] nums = {{1,2},{3,4}};
        matrixReshap.matrixReshape(nums, 1, 4);
    }
}
