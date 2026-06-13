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

            int rightMax = matrix[0].length - 1;
            int bottomMax = matrix.length  -1;
            int leftMax = 0;
            int topMax = 0;

            if (indexes.contains(nextI + "." + nextJ)) {
                if (rowDirection == 0 && columnDirection == 1) {
                    rightMax = j;
                } else if (rowDirection == 1 && columnDirection == 0) {
                    bottomMax = i;
                } else if (columnDirection == -1 && rowDirection == 0) {
                    leftMax = j;
                } else if (columnDirection == 0 && rowDirection == -1) {
                    topMax = i;
                }
            }


            if (rowDirection == 0 && columnDirection == 1 && j >= rightMax) { // Going right hit max
                rowDirection = 1;
                columnDirection = 0;
            } else if (rowDirection == 1 && columnDirection == 0 && i >= bottomMax) { // Going bottom hit max
                rowDirection = 0;
                columnDirection = -1;
            } else if (columnDirection == -1 && rowDirection == 0 && j <= leftMax) { // Hit 
                columnDirection = 0;
                rowDirection = -1;
            } else if (columnDirection == 0 && rowDirection == -1 && i <= topMax) {
                columnDirection = 1;
                rowDirection = 0;
            }

            i = i + rowDirection;
            j = j + columnDirection;
        }

        return result;
    }
}