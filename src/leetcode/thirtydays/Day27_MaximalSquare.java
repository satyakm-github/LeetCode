package leetcode.thirtydays;

public class Day27_MaximalSquare {

	public static void main(String[] args) {
		System.out.println(maximalSquare(new char[][] {
			{'1', '0', '1', '0', '0'},
			{'1', '0', '1', '1', '1'},
			{'1', '1', '1', '1', '1'},
			{'1', '0', '0', '1', '0'},
		}));
		
		System.out.println(maximalSquare(new char[][] {
			{'1'},
		}));
	}

	public static int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int max = 0;

		int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];

		for (int i = 1; i <= matrix.length; i++) {
			for (int j = 1; j <= matrix[0].length; j++) {
				if (matrix[i-1][j-1] == '1') {
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
					max = Math.max(max, dp[i][j]);
				}
			}
		}

		return max * max;
	}
}
