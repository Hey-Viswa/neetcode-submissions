public class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];

                if (ch == '.') {
                    continue;
                }

                // Maps '1'-'9' to index 0-8
                int num = ch - '1';

                // Maps (r, c) to box index 0-8
                int boxIdx = (r / 3) * 3 + (c / 3);

                // If already seen in the same row, col, or 3x3 box
                if (rows[r][num] || cols[c][num] || boxes[boxIdx][num]) {
                    return false;
                }

                // Mark as seen
                rows[r][num] = true;
                cols[c][num] = true;
                boxes[boxIdx][num] = true;
            }
        }

        return true;
    }
}