package geekforgeeks;

import java.util.Stack;

//https://www.geeksforgeeks.org/next-greater-element/
public class NextGreaterElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {5,1,3,7,4};
		
		Stack<Integer> stack = new Stack();
		Stack<Integer> res = new Stack();
		res.push(-1);
		stack.push(arr[arr.length-1]);
		for(int i=arr.length-2;i>=0;i--) {
			if(arr[i]<stack.peek()) {
				res.push(stack.peek());
				stack.push(arr[i]);
			}else {
				stack.pop();
				boolean found = false;
				while(!stack.isEmpty()) {
					if(arr[i]<stack.peek()) {
						res.push(stack.peek());
						stack.push(arr[i]);
						found = true;
						break;
					}
					stack.pop();
				}
				if(!found) {
					res.push(-1);
					stack.push(arr[i]);
				}
			}
		}
		
		while(!res.isEmpty()) {
			System.out.println(res.pop());
		}

	}

}
