package com.hatella.algorithm.leetcode.mine;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeating {

	public static void main(String args[]) {
		LongestSubstringWithoutRepeating longestSubstringWithoutRepeating = new LongestSubstringWithoutRepeating();
		System.out.println(longestSubstringWithoutRepeating.lengthOfLongestSubstring("tmmzuxt"));
	}
	
	public int lengthOfLongestSubstring(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int currLen = 0;
		int maxLen = 0;
		for(int i = 0; i < s.length(); i++) {
			if(map.containsKey(s.charAt(i))) {
				maxLen = Math.max(currLen, maxLen);
				int prevIndex = map.get(s.charAt(i));
				if(i-currLen>prevIndex) {
					currLen++;
				} else {
					currLen = i-prevIndex;
				}
				map.put(s.charAt(i), i);
			} else {
				map.put(s.charAt(i), i);
				currLen++;
			}
		}
		return Math.max(currLen, maxLen);
    }
}
