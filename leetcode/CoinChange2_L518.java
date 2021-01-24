package leetcode;

public class CoinChange2_L518 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {};
		int amount =0;
		CoinChange2_L518 obj = new CoinChange2_L518();
		 obj.change(amount, arr);
	}
	
	public int change(int amount, int[] coins) {
        //return helper(coins, amount, 0);
        //Integer[][] dp = new Integer[coins.length][amount+1];
        //return helper2(coins, amount,0,dp);
        return helper3(coins, amount);
        
    }
    
    //recursion    
    private int helper(int[] coins, int amount, int n){
        if(amount == 0){
            return 1;
        }
        if(n >=coins.length){
            return 0;
        }
        
        int sum1 = 0;
        int sum2 = 0;
        if(amount>= coins[n]){
            sum1 = helper(coins, amount-coins[n], n);
        }
        sum2 = helper(coins, amount, n+1);
        
        return sum1 + sum2;
    }
    
    //memoization
    private int helper2(int[] coins, int amount, int n, Integer[][] dp){
        if(amount == 0){
            return 1;
        }
        if(n >=coins.length){
            return 0;
        }
        
        if(dp[n][amount] != null){
            return dp[n][amount];
        }
        
        int sum1 = 0;
        int sum2 = 0;
        if(amount>= coins[n]){
            sum1 = helper(coins, amount-coins[n], n);
        }
        sum2 = helper(coins, amount, n+1);
        
        dp[n][amount]= sum1 + sum2;
        return  dp[n][amount];
    }
    
    private int helper3(int[] arr, int amount){
        
        int[][] dp = new int[arr.length+1][amount+1];
        
        for(int i=0;i<dp.length;i++){
            dp[i][0] = 1;
        }
        
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(j>=arr[i-1]){
                   dp[i][j] = dp[i-1][j] + dp[i][j-arr[i-1]]; 
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[arr.length][amount];
        
    }

}
