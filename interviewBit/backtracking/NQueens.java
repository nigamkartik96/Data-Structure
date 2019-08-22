/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 *
 * N Queens: Example 1
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens’ placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 *
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 *
 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 */
package backtracking;

import java.util.ArrayList;

public class NQueens {
    public ArrayList<ArrayList<String>> solveNQueens(int a) {
        ArrayList<ArrayList<String>> solutions = new ArrayList<ArrayList<String>>();

        ArrayList<String> rows = new ArrayList<String>();
        for (int i = 0; i < a; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < i; j++) {
                row.append(".");
            }
            row.append("Q");
            for (int j = i + 1; j < a; j++) {
                row.append(".");
            }
            rows.add(row.toString());
        }
        solveNQueens(rows, new ArrayList<String>(), solutions);
        return solutions;
    }

    private void solveNQueens(ArrayList<String> available, ArrayList<String> choosen, ArrayList<ArrayList<String>> solutions) {
        if (available.isEmpty()) {
            solutions.add(new ArrayList<String>(choosen));
            return;
        }

        for (int i = 0; i < available.size(); i++) {
            String row = available.remove(i);
            choosen.add(row);
            if (isValid(choosen)) {
                solveNQueens(available, choosen, solutions);
            }
            // backtrack
            available.add(i, row);
            choosen.remove(choosen.size() - 1);
        }
    }

    private boolean isValid(ArrayList<String> choosen) {
        int last = choosen.size() - 1;
        String row = choosen.get(last);
        int queenPosition = row.indexOf("Q");

        int diff = 0;
        for (int i = last - 1; i >= 0; i--) {
            diff++;
            String existingRow = choosen.get(last - diff);
            if (existingRow.indexOf("Q") == queenPosition + diff
                    || existingRow.indexOf("Q") == queenPosition - diff) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        NQueens queens = new NQueens();
        System.out.println(queens.solveNQueens(4));
    }
}
