package leetcode.thirtydays.may;

import java.util.ArrayList;
import java.util.List;

public class Day03_RansomNote {

	public static void main(String[] args) {
		System.out.println(canConstruct("a", "b"));
		System.out.println(canConstruct("aa", "ab"));
		System.out.println(canConstruct("aa", "aab"));
	}

	public static boolean canConstruct(String ransomNote, String magazine) {

		if (ransomNote.length() == 0 && magazine.length() == 0) {
			return true;
		}

		if (ransomNote.length() == 0 && magazine.length() > 0) {
			return true;
		}

		List<Character> list = new ArrayList<Character>();
		for (Character c : magazine.toCharArray()) {
			list.add(c);
		}

		for (Character c : ransomNote.toCharArray()) {
			if (list.contains(c)) {
				list.remove(list.indexOf(c));
			} else {
				return false;
			}
		}
		return true;

	}
}
