//https://leetcode.com/problems/longest-palindromic-substring/
package String;

import Utils.Utils;

public class LongestPalindromicSubString5 {

	static Utils utils = new Utils();

	Utils util = new Utils();

	public static void main(String[] args) {

		LongestPalindromicSubString5 cn = new LongestPalindromicSubString5();

		utils.printLine(cn.longestPalindrome(
				"azwdzwmwcqzgcobeeiphemqbjtxzwkhiqpbrprocbppbxrnsxnwgikiaqutwpftbiinlnpyqstkiqzbggcsdzzjbrkfmhgtnbujzszxsycmvipjtktpebaafycngqasbbhxaeawwmkjcziybxowkaibqnndcjbsoehtamhspnidjylyisiaewmypfyiqtwlmejkpzlieolfdjnxntonnzfgcqlcfpoxcwqctalwrgwhvqvtrpwemxhirpgizjffqgntsmvzldpjfijdncexbwtxnmbnoykxshkqbounzrewkpqjxocvaufnhunsmsazgibxedtopnccriwcfzeomsrrangufkjfzipkmwfbmkarnyyrgdsooosgqlkzvorrrsaveuoxjeajvbdpgxlcrtqomliphnlehgrzgwujogxteyulphhuhwyoyvcxqatfkboahfqhjgujcaapoyqtsdqfwnijlkknuralezqmcryvkankszmzpgqutojoyzsnyfwsyeqqzrlhzbc"));
		utils.printLine(cn.longestPalindrome("abcdeffe"));
	}

	public String longestPalindrome(String s) {
		int fi, bi, len = s.length();
		char fc, bc, c;
		if (len == 0)
			return "";
		if (len == 1)
			return s.charAt(0) + "";
		String ans = s.charAt(0) + "";
		for (int i = 0; i < len - 1; i++) {
			c = s.charAt(i);
			int res[] = getFiBi(s, i);
			bi = res[0];
			fi = res[1];
			int newI = fi;

			if (ans.length() < s.substring(bi, fi + 1).length())
				ans = s.substring(bi, fi + 1);

			while (fi < len && bi >= 0) {
				fc = s.charAt(fi);
				bc = s.charAt(bi);
				if (fc == bc) {
					if (ans.length() < s.substring(bi, fi + 1).length())
						ans = s.substring(bi, fi + 1);
					fi++;
					bi--;
				} else
					break;
			}
		}
		return ans;
	}

	public int[] getFiBi(String s, int index) {
		int len = s.length(), last = index;
		for (int i = index + 1; i < len; i++) {
			last = i;
			if (s.charAt(i - 1) != s.charAt(i))
				return new int[] { index, i - 1 };
		}
		return new int[] { index, last };
	}

	// 2 5 7 3 5
}
