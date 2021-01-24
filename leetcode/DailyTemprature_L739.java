package leetcode;

import java.util.Stack;

public class DailyTemprature_L739 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] dailyTemperatures(int[] T) {
        
        Stack<int[]> stack = new Stack<>();
        int[] res = new int[T.length];
        
        for(int i=T.length -1;i>=0;i--){
            if(stack.isEmpty()){
                stack.push(new int[]{T[i],i});
                res[i]=0;
            }
            else{
                int span = 0;
                while(!stack.isEmpty() && stack.peek()[0] <= T[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    stack.push(new int[]{T[i],i});
                    res[i]=0;
                }else{
                    int index = stack.peek()[1];
                    res[i] = index -i;
                    stack.push(new int[]{T[i],i});
                }
            }
        }
        
        return res;
        
    }

}
