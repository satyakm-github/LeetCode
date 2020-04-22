package leetcode.easy;

public class Prob704_BinarySearch {

	public static void main(String[] args) {
		System.out.println(search(new int[] { -1, 0, 3, 5, 9, 12 }, 9));
		System.out.println(search(new int[] { -1, 0, 3, 5, 9, 12 }, 2));
		System.out.println(search(new int[] { 2 }, 2));
	}

	public static int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (target < nums[mid]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}
}
