class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rowIndex = new HashSet<>();
        Set<Integer> columnIndex = new HashSet<>();
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rowIndex.add(i);
                    columnIndex.add(j);
                }
            }
        }
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (rowIndex.contains(i) || columnIndex.contains(j)) {
                     matrix[i][j] = 0;
                }
            }
        }
        
    }
}
