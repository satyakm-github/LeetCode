package leetcode.easy;

public class Prob342_IsPowerOf4 {

	public static void main(String[] args) {
		System.out.println(isPowerOfFour(16));
		System.out.println(isPowerOfFour(5));
	}

	public static boolean isPowerOfFour(int n) {
		if (n == 0) {
			return false;
		}
		if (n == 1) {
			return true;
		} else {
			return n % 4 == 0 && isPowerOfFour(n / 4);
		}
	}
	
	static public boolean isPowerOfFourLogApproach(int num) {
		if (num <= 0)
			return false;
		double logValue = Math.log(num) / Math.log(4);
		return (logValue % 1) == 0;
	}
}