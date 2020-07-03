package leetcode.easy;

import java.util.Arrays;

public class Prob566_ReshapreTheMatrix {

	public static void main(String[] args) {
		print(matrixReshape(new int[][] { { 1, 2 }, { 3, 4 } }, 1, 4));
		print(matrixReshape(new int[][] { { 1, 2 }, { 3, 4 } }, 2, 4));
	}

	static public int[][] matrixReshape(int[][] nums, int r, int c) {
		if (nums == null || nums.length == 0 || nums[0].length == 0) {
			return nums;
		}
		if (r * c != nums.length * nums[0].length) {
			return nums;
		}
		int[][] newarr = new int[r][c];

		int counter = 0;
		int[] oneDimArr = new int[nums.length * (nums[0].length)];
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[i].length; j++) {
				oneDimArr[counter++] = nums[i][j];
			}
		}

		counter = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				newarr[i][j] = oneDimArr[counter++];
			}
		}
		return newarr;
	}

	static void print(int[][] a) {
		for (int[] eachRow : a) {
			System.out.println(Arrays.toString(eachRow));
		}
		System.out.println();
	}
}
