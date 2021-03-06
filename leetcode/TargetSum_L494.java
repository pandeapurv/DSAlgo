package leetcode;

public class TargetSum_L494 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public int findTargetSumWays(int[] nums, int S) {
	        
	        int sum=0;
			for(int i=0;i<nums.length;i++) {
				sum+=nums[i];
			}
	        if(S > sum || (sum + S)%2 !=0){
	            return 0;
	        }
			int target = (S+sum)/2;
	        return helper(nums, target);
	    }
	    
	    private static int helper(int[] arr, int sum) {
			int[][] dp = new int[arr.length+1][sum+1];
			
	        dp[0][0] =1;
	        // special case if number is 0
			for(int i=1;i<dp.length;i++) {
	            if(arr[i-1] == 0){
	               dp[i][0]=dp[i-1][0] *2; 
	            }else{
	                dp[i][0]=dp[i-1][0];
	            }
				
			}
			
			for(int i=1;i<dp.length;i++) {
				for(int j=1;j<dp[0].length;j++) {
					if(j>=arr[i-1]) {
						dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]];
					}else {
						dp[i][j] = dp[i-1][j];
					}
				}
			}
			return dp[arr.length][sum];
		}

}
