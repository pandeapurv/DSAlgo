package geekforgeeks;

public class SubSetSum {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5,2,3};
		
		System.out.println(helper(arr,8));
	}
	
	private static boolean helper(int[] arr, int sum) {
		boolean[][] dp = new boolean[arr.length+1][sum+1];
		
		for(int i=0;i<dp.length;i++) {
			dp[i][0] = true;
		}
		
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				if(j>=arr[i-1]) {
					dp[i][j] = dp[i-1][j] || dp[i-1][j - arr[i-1]];
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[arr.length][sum];
	}

}
