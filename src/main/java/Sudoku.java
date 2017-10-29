import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 孙亮 on 2017/5/5.
 */
public class Sudoku {
    public void solveSudoku(char[][] board) {
        int[] blankCell = getNextBlankCell(board);
        if(blankCell[0] < 0) return;

        char[] candidateNum = getCandidateNum(board, blankCell[0], blankCell[1]);
        for(int i = 0; i < candidateNum.length; i++) {
            System.out.println(String.format("Put %c in [%d, %d]", candidateNum[i], blankCell[0],
                    blankCell[1]));
            board[blankCell[0]][blankCell[1]] = candidateNum[i];
            solveSudoku(board);
            if(!hasBlankCell(board)) {
                break;
            }
        }
        if(hasBlankCell(board)) {
            System.out.println(String.format("Set [%d, %d] Empty",blankCell[0],blankCell[1]));
            board[blankCell[0]][blankCell[1]] = '.';
        }
        return;
    }

    private int[] getNextBlankCell(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == '.') {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    private boolean hasBlankCell(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == '.') {
                    return true;
                }
            }
        }
        return false;
    }

    private char[] getCandidateNum(char[][] board, int x, int y) {
        List<Character> numbers = new ArrayList<Character>() {{
            add('1'); add('2'); add('3'); add('4');
            add('5'); add('6'); add('7'); add('8'); add('9');
        }};

        for(int i = 0; i < board.length; i++) {
            if(numbers.contains(board[i][y])) {
                numbers.remove(new Character(board[i][y]));
            }
        }
        for(int i = 0; i < board[0].length; i++) {
            if(numbers.contains(board[x][i])) {
                numbers.remove(new Character(board[x][i]));
            }
        }

        for(int i = x/3 * 3; i < x/3*3+3; i ++) {
            for(int j = y/3 * 3; j < y/3*3+3; j++) {
                if(numbers.contains(board[i][j])) {
                    numbers.remove(new Character(board[i][j]));
                }
            }
        }

        char[] result = new char[numbers.size()];
        for(int i = 0; i < result.length; i ++) {
            result[i] = numbers.get(i);
        }
        return result;
    }

    public boolean isValidSudoku(char[][] board) {
        Map<Character, Integer> result = new HashMap<Character, Integer>();
        result.put(new Character('c'), 1);

        for(int i = 0; i < board.length; i++) {
            List<Character> row = new ArrayList<Character>();
            List<Character> column = new ArrayList<Character>();
            List<Character> cube = new ArrayList<Character>();
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] != '.') {
                    if(!row.contains(board[i][j])) {
                        row.add(board[i][j]);
                    } else {
                        return false;
                    }
                }

                if(board[j][i] != '.') {
                    if(!column.contains(board[j][i])) {
                        column.add(board[j][i]);
                    } else {
                        return false;
                    }
                }

                int cubeI = i/3*3 + j/3;
                int cubeJ = i%3*3 + j%3;
                if(board[cubeI][cubeJ] != '.') {
                    if(!cube.contains(board[cubeI][cubeJ])) {
                        cube.add(board[cubeI][cubeJ]);
                    } else {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();
//        char[][] sudo = new char[][]{
//                {'.','.','9','7','4','8','.','.','.'},
//                {'7','.','.','.','.','.','.','.','.'},
//                {'.','2','.','1','.','9','.','.','.'},
//                {'.','.','7','.','.','.','2','4','.'},
//                {'.','6','4','.','1','.','5','9','.'},
//                {'.','9','8','.','.','.','3','.','.'},
//                {'.','.','.','8','.','3','.','2','.'},
//                {'.','.','.','.','.','.','.','.','6'},
//                {'.','.','.','2','7','5','9','.','.'}};
//
//        sudoku.solveSudoku(sudo);

        char[][] sudo = new char[][]{
                {'.','8','7','6','5','4','3','2','1'},
                {'2','.','.','.','.','.','.','.','.'},
                {'3','.','.','.','.','.','.','.','.'},
                {'4','.','.','.','.','.','.','.','.'},
                {'5','.','.','.','.','.','.','.','.'},
                {'6','.','.','.','.','.','.','.','.'},
                {'7','.','.','.','.','.','.','.','.'},
                {'8','.','.','.','.','.','.','.','.'},
                {'9','.','.','.','.','.','.','.','.'}};

        System.out.println(sudoku.isValidSudoku(sudo));
    }
}
