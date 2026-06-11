class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1;

        while (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length) {
            int current = matrix[i][j];
            System.out.println(current);
            if (target > current) {
                i++;
            } else if (target < current) {
                j--;
            } else {
                return true;
            }
        }

        return false;
    }
}
