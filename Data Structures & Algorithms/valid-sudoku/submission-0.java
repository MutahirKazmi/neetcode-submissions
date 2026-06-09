class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rowSetArray = new HashSet[9];
        Set<Character>[] columnSetArray = new HashSet[9];
        Set<Character>[][] miniGridSetArray = new HashSet[3][3];
        
        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[i].length; j++) {
                if (rowSetArray[i] == null) {
                    rowSetArray[i] = new HashSet<Character>();
                }

                if (columnSetArray[j] == null) {
                    columnSetArray[j] = new HashSet<Character>();
                }
                
                if (miniGridSetArray[i/3][j/3] == null) {
                    miniGridSetArray[i/3][j/3] = new HashSet<Character>();
                }

                if (miniGridSetArray[i/3][j/3].contains(board[i][j]) || columnSetArray[j].contains(board[i][j]) || rowSetArray[i].contains(board[i][j])) {
                    return false;
                }

                if (board[i][j] != '.') {
                    rowSetArray[i].add(board[i][j]);
                    columnSetArray[j].add(board[i][j]);
                    miniGridSetArray[i/3][j/3].add(board[i][j]);                    
                }
            }
        }
        
        return true;
    }
}