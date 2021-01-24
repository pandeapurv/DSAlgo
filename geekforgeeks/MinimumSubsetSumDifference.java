package geekforgeeks;

public class MinimumSubsetSumDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 6, 11, 5} ;
		System.out.println(helper(arr));
	}
	
	private static int helper(int[] arr) {
		
		int sum = 0;
		for(int i=0;i<arr.length;i++) {
			sum +=arr[i];
		}
		
		int target = sum/2;
		boolean[][] dp = new boolean[arr.length+1][target+1];
		
		int minDiff = sum;
		
		for(int i=0;i<dp.length;i++) {
			dp[i][0] = true;
		}
		
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				if(j >= arr[i-1]) {
					dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		for(int j=target;j>=0;j--) {
			if(dp[arr.length][j]) {
				minDiff=Math.min(minDiff,  sum -2*j);
			}
		}
		return minDiff;
	}

}
