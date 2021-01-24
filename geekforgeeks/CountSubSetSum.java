package geekforgeeks;

public class CountSubSetSum {
	static int count = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,0,0};
		helper(arr,6,0);
		
		System.out.println(helper2(arr,5));
	}
	
	//recursion
	private static void helper(int[] arr ,int sum, int n) {
	
		if(n==arr.length) {
			if(sum == 0) {
				count++;
			}
			return;
		}
				
		if(sum>=arr[n]) {
			helper(arr,sum-arr[n],n+1);
		}
		helper(arr,sum,n+1);
	}
	
	
	private static int helper2(int[] arr, int sum) {
		int[][] dp = new int[arr.length+1][sum+1];
		
		for(int i=0;i<dp.length;i++) {
			dp[i][0]=1;
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
