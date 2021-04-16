package HW7;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0){
                    row.add(i);
                    col.add(j);
                }
            }
        }

        for(int a : row){
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[a][i] = 0;
            }
        }
        for(int b : col){
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][b] = 0;
            }
        }

    }
}
