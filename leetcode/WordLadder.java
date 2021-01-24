package leetcode;
import java.util.*;
public class WordLadder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> wordList = new ArrayList<>();
		wordList =Arrays.asList(new String[] {"hot","dot","dog","lot","log","cog"});
		System.out.println(ladderLength("hit","cog",wordList));
	}
	
	
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord == null || endWord == null){
            return 0;
        }
        
        //List<List<String>> res = new ArrayList<>();
        
        Set<String> wordSet = new HashSet<>();
        Set<String> seenSet = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        for(String w : wordList){
            wordSet.add(w);
        }
        int counter = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int k=0;k<size;k++){
                String word = queue.poll();
 //               if(!seenSet.contains(word)){
                   seenSet.add(word);
                   char[] arr = word.toCharArray();
                    for(int i=0;i<arr.length;i++){
                        char temp = arr[i];
                        for(char c='a';c<='z';c++){
                            if(c == temp) continue;
                            arr[i] = c;
                            String newWord = new String(arr);
                            if(!seenSet.contains(newWord) &&
                              wordSet.contains(newWord)){
                                if(newWord.equals(endWord)){
                                    return counter;
                                }
                                seenSet.add(newWord);
                                queue.add(newWord);
                            }
                        }
                        arr[i] =temp;
                    }
                }
            //}
            counter++;
        }
        return 0;
    }

}
