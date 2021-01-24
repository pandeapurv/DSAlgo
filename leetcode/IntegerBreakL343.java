package leetcode;

import java.util.Arrays;

public class IntegerBreakL343 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		int[] dp = new int[n+1];
		Arrays.fill(dp,-1);
		System.out.println(helper(n,dp));
	}
	
	private static int helper(int w,int[] dp){
        
        int max=1;
        if(dp[w] !=-1) {
        	return dp[w];
        }
        for(int i=1;i<=w/2;i++){
            int factor1 = Math.max(i,helper(i,dp));
            int factor2 = Math.max(w-i,helper(w-i,dp));
            max = Math.max(max, factor1*factor2);
        }
        dp[w] = max;
        return max;
    }
	
	

}
