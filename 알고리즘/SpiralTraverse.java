// MxN 행렬을 달팽이 껍질 모양으로 나선 순환하는 알고리즘

public class Solution {
    public String spiralTraversal(Character[][] matrix) {
        StringBuilder sb = new StringBuilder();

        int y_start = 0; // Starting Row Index
        int y_end = matrix.length - 1; // Ending Row Index
        int x_start = 0; // Starting Col Index
        int x_end = matrix[0].length - 1; // Ending Col Index

        while (x_start <= x_end && y_start <= y_end) {
            for(int x = x_start; x <= x_end; x++) {
                sb.append(matrix[y_start][x]);
            }
            y_start++;

            for(int y = y_start; y <= y_end; y++) {
                sb.append(matrix[y][x_end]);
            }
            x_end--;

            if(y_start <= y_end) {
                for(int x = x_end; x >= x_start; x--) {
                    sb.append(matrix[y_end][x]);
                }
            }
            y_end--;

            if(x_start <= x_end) {
                for(int y = y_end; y >= y_start; y--) {
                    sb.append(matrix[y][x_start]);
                }
            }
            x_start++;
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}
