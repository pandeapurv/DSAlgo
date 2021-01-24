package leetcode;
import java.util.Stack;

public class LargestRectangleHistogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = new int[3][2];
		LargestRectangleHistogram obj = new LargestRectangleHistogram();
		obj.largestRectangleArea(arr[1]);

	}
	
	public int largestRectangleArea(int[] heights) {
        int[] nsr = getNSR(heights);
        int[] nsl = getNSL(heights);
        
        int maxArea = 0;
        for(int i=0;i<heights.length;i++){
            int area = heights[i] * (nsr[i]-nsl[i] -1);
            maxArea = Math.max(maxArea,area);
        }
        
        return maxArea;
    }
    
    public int[] getNSR(int[] heights){
        int[] res = new int[heights.length];
        Stack<int[]> stack = new Stack<>();
        for(int i=heights.length-1;i>=0;i--){
            if(stack.isEmpty()){
                stack.push(new int[]{heights[i],i});
                res[i] = heights.length;
            }else{
                while(!stack.isEmpty() && stack.peek()[0] >= heights[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    stack.push(new int[]{heights[i],i});
                    res[i] = heights.length;
                }else{
                    res[i] =  stack.peek()[1];
                    stack.push(new int[]{heights[i],i});                    
                }
            }
        }
        return res;
    }
    
    public int[] getNSL(int[] heights){
        int[] res = new int[heights.length];
        Stack<int[]> stack = new Stack<>();
        for(int i=0;i<heights.length;i++){
           if(stack.isEmpty()){
                stack.push(new int[]{heights[i],i});
                res[i] = -1;
            }else{
               while(!stack.isEmpty() && stack.peek()[0] >= heights[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    stack.push(new int[]{heights[i],i});
                    res[i] = -1;
                }else{
                    res[i] =  stack.peek()[1];
                    stack.push(new int[]{heights[i],i});                    
                }
           }
        }
        return res;
    }

}
