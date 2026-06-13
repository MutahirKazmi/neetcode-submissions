class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        Set<String> indexes = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        int rowDirection = 0;
        int columnDirection = 1;
        int i = 0;
        int j = 0;
        
        while (indexes.size() != matrix.length * matrix[0].length) {
            indexes.add(i + "." + j);
            result.add(matrix[i][j]);
            
            int nextI = i + rowDirection;
            int nextJ = j + columnDirection;

            if (nextI >= 0 && nextI < matrix.length && nextJ >= 0 
            && nextJ < matrix[0].length 
            && !indexes.contains(nextI + "." + nextJ)) {
                i = nextI;
                j = nextJ;
                continue;
            } else {
                if (rowDirection == 0 && columnDirection == 1) { // Going right hit max
                    rowDirection = 1;
                    columnDirection = 0;
                } else if (rowDirection == 1 && columnDirection == 0) { // Going bottom hit max
                    rowDirection = 0;
                    columnDirection = -1;
                } else if (columnDirection == -1 && rowDirection == 0 ) { // Hit 
                    columnDirection = 0;
                    rowDirection = -1;
                } else if (columnDirection == 0 && rowDirection == -1 ) {
                    columnDirection = 1;
                    rowDirection = 0;
                }
                i = i + rowDirection;
                j = j + columnDirection;
            }
        }

        return result;
    }
}