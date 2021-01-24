package leetcode;

public class CoinChange_L322 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {};
		int amount =0;
		CoinChange_L322 obj = new CoinChange_L322();
		 obj.helper(arr,amount);

	}
	
	private int helper(int[] coins, int amount){
        int[][] dp = new int[coins.length+1][amount+1];
        
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(j==0){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = amount+1;
                }
            }
            
        }
        
        dp[0][0] =0;
        
        
        
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(j>=coins[i-1]){
                    dp[i][j] = Math.min(dp[i-1][j], 1+ dp[i][j-coins[i-1]]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        if(dp[coins.length][amount] == amount+1){
            return -1;
        }
        
        return dp[coins.length][amount];
    }

}
