package leetcode;

import java.util.*;

public class WOrdBreak2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * "catsanddog"
["cat","cats","and","sand","dog"]
		 * */
		String s = "catsanddog";
		List<String> tmp = new ArrayList<>();
		tmp.add("cat");
		tmp.add("cats");
		tmp.add("and");
		tmp.add("sand");
		tmp.add("dog");
		wordBreak(s,tmp);
	}

	public static List<String> wordBreak(String s, List<String> wordDict) {
		Set<String> set = new HashSet<>();
		for (String word : wordDict) {
			set.add(word);
		}
		List<String> res = helper(s, set, new HashMap<>());
		for(String reswor: res) {
			System.out.println(reswor);
		}
		return res;
	}

	private static List<String> helper(String s, Set<String> wordDictSet, Map<String, List<String>> map) {
		List<String> res = new ArrayList<>();
		if (s == null || s.trim().length() == 0) {
			return res;
		}

		if (map.containsKey(s)) {
			return map.get(s);
		}

		if (wordDictSet.contains(s)) {
			res.add(s);
		}

		for (int i = 1; i < s.length(); i++) {
			if (wordDictSet.contains(s.substring(i))) {
				List<String> tmp = helper(s.substring(0, i), wordDictSet, map);
				if (tmp != null && tmp.size() > 0) {

					for (int j = 0; i < tmp.size(); j++) {
						res.add(tmp.get(j) + " " + s.substring(i));
					}
				}
			}
		}
		map.put(s, res);
		return res;
	}

}
