import java.util.*;

public class Solution { 
	public int[][] rotateMatrix(int[][] matrix, int K) {
		if(matrix == null) {
			return null;
		}

		for(int i = 0; i < K; i++) {
			matrix = rotate(matrix);
		}
		return matrix;
  }

  // 회전된 새로운 행렬을 만들어서 리턴
	private int[][] rotate(int[][] before) {
		int M = before.length;
		int N = before[0].length;
		int[][] after = new int[N][M];

		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				after[j][M - i - 1] = before[i][j];
			}
		}
		return after;
	}
}
