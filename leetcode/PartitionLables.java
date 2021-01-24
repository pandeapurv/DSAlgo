package leetcode;

import java.util.*;

public class PartitionLables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		partitionLabels("ababcbacadefegdehijhklij");
	}

	public static List<Integer> partitionLabels(String S) {

		
		int[] lastIndexArr = new int[26];
		Arrays.fill(lastIndexArr, -1);
		
		for (int i = 0; i < S.length(); i++) {
			char ch = S.charAt(i);
			

			lastIndexArr[ch - 'a'] = i;
		}

		Stack<Integer> stack = new Stack<>();
		
		for(int i=0;i<S.length();i++) {
			char ch = S.charAt(i);
			if(stack.isEmpty()) {
				stack.push(lastIndexArr[ch - 'a']);
				continue;
			}
			if(i> stack.peek()) {
				stack.push(lastIndexArr[ch - 'a']);
			}else {
				if(lastIndexArr[ch - 'a'] > stack.peek()) {
					stack.pop();
					stack.push(lastIndexArr[ch - 'a']);
				}
			}
		}

		
		
		int[] arr = new int[stack.size()];
		
		int i=arr.length-1;
		while(!stack.isEmpty()) {
			arr[i--] = stack.pop();
		}

		List<Integer> res = new ArrayList<>();
		for(int j=0;j<arr.length;j++) {
			if(j == 0) {
				res.add(arr[j]+1);
			}else {
				res.add(arr[j] - arr[j-1] );
			}
		}

		return res;

	}

}
