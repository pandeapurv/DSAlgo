package leetcode;

import java.util.Stack;

public class OnlineStockSpan_L901 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2};
		Stack<int[]> s = new Stack<>();
		s.push(new int[]{1,3});
	}
	
	Stack<int[]> stack;

    public OnlineStockSpan_L901() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        while(!stack.isEmpty() && stack.peek()[0] <= price){
            span += stack.pop()[1];
        }
        
        stack.push(new int[]{price,span});
        return span;
    }

}
