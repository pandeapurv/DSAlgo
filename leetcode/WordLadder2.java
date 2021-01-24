package leetcode;

import java.util.*;


public class WordLadder2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> wordList = new ArrayList<>();
		wordList = Arrays.asList(new String[] { "hot", "dot", "dog", "lot", "log", "cog" });
		List<List<String>> res = findLadders2("hit", "cog", wordList);

	}
	
	public static List<List<String>> findLadders2(String beginWord, String endWord, List<String> wordList) {
		List<List<String>> res = new ArrayList<>();
		if (beginWord == null || endWord == null) {
			return res;
		}
		
		Set<String> wordSet = new HashSet<>();
		
		for (String w : wordList) {
			wordSet.add(w);
		}
		
		Queue<String> queue = new LinkedList<>();
		queue.add(beginWord);
		
		Map<String, Integer> map = new HashMap<>();
		Map<String, List<String>> adjList = new HashMap<>();
		map.put(beginWord,0);
		adjList.put(beginWord, new ArrayList<>());
		boolean  found = false;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int k=0;k<size;k++) {
				String word = queue.poll();
				char[] arr = word.toCharArray();
				for (int i = 0; i < arr.length; i++) {
					char temp = arr[i];
					for (char c = 'a'; c <= 'z'; c++) {
						if (c == temp)
							continue;
						arr[i] = c;
						String newWord = new String(arr);
						if(wordSet.contains(newWord)) {
							if(!map.containsKey(newWord)) {
								map.put(newWord, map.get(word)+1);
								adjList.put(newWord, new ArrayList<>());
								adjList.get(word).add(newWord);
								queue.add(newWord);
							}else if (map.containsKey(newWord) && map.get(newWord)> map.get(word)) {
								adjList.put(newWord, new ArrayList<>());
								adjList.get(word).add(newWord);
							}
							if (newWord.equals(endWord)) {
								found = true;
								
							}
						}
						arr[i] = temp;
					}
				}
				
			}
			if(found) {
				dfs(beginWord, endWord, adjList,map,res,new ArrayList<>());
				System.out.println("s");
			}
		}
		
		
		
		
		return res;
	}
	
	private static void dfs(String currWord, String endWord,Map<String, List<String>> adjList,Map<String, Integer> map,
			List<List<String>> res, List<String> tmp) {
		tmp.add(currWord);
		if(currWord.equals(endWord)) {
			res.add(new ArrayList<>(tmp));
		}else {
			for(String neighbor : adjList.get(currWord)) {
				if(map.get(neighbor)>map.get(currWord)) {
					dfs(neighbor,endWord, adjList,map, res, tmp);
				}
			}
		}
		tmp.remove(tmp.size()-1);
	}

	public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

		List<List<String>> res = new ArrayList<>();
		if (beginWord == null || endWord == null) {
			return res;
		}

		Set<String> wordSet = new HashSet<>();
		Set<String> seenSet = new HashSet<>();
		Queue<String> queue = new LinkedList<>();
		queue.add(beginWord);
		for (String w : wordList) {
			wordSet.add(w);
		}
		int counter = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int k = 0; k < size; k++) {
				String word = queue.poll();
				// if(!seenSet.contains(word)){
				seenSet.add(word);
				char[] arr = word.toCharArray();
				for (int i = 0; i < arr.length; i++) {
					char temp = arr[i];
					for (char c = 'a'; c <= 'z'; c++) {
						if (c == temp)
							continue;
						arr[i] = c;
						String newWord = new String(arr);
						if (!seenSet.contains(newWord) && wordSet.contains(newWord)) {
							if (newWord.equals(endWord)) {
								// return counter;
								dfs(beginWord, endWord, wordSet, new HashSet<>(), counter+1, 0, res, new ArrayList<>());
								return res;
							}
							seenSet.add(newWord);
							queue.add(newWord);
						}
					}
					arr[i] = temp;
				}
			}
			// }
			counter++;
		}
		return res;
	}

	private static void dfs(String beginWord, String endWord, Set<String> wordSet, Set<String> seenSet, int pathLength,
			int counter, List<List<String>> res, List<String> tmp) {
		if (tmp.size() >= pathLength) {
			return;
		}
		if (beginWord.equals(endWord)) {
			tmp.add(endWord);
			res.add(new ArrayList<>(tmp));
			tmp.remove(tmp.size()-1);
			return;
		}

		char[] arr = beginWord.toCharArray();
		tmp.add(beginWord);
		seenSet.add(beginWord);
		if(beginWord.equals("dot")) {
			System.out.println("D");
		}
		for (int i = 0; i < arr.length; i++) {
			char temp = arr[i];
			for (char c = 'a'; c <= 'z'; c++) {
				if (c == temp)
					continue;
				arr[i] = c;
				String newWord = new String(arr);
				if (!seenSet.contains(newWord) && wordSet.contains(newWord)) {
					seenSet.add(newWord);
					System.out.println();
					for(String s : tmp) {
						
						System.out.print(" " + s);
						
					}
					System.out.println();
					dfs(newWord, endWord, wordSet, seenSet, pathLength, counter + 1, res, tmp);
					seenSet.remove(newWord);
				}
			}
			arr[i] = temp;
		}
		tmp.remove(tmp.size() - 1);

	}

}
