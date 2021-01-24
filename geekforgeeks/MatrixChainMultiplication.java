package geekforgeeks;

public class MatrixChainMultiplication {

	//static int  min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {40, 20, 30, 10, 30} ;
		System.out.println(helper(arr, 1, arr.length-1));
		
		int[][] dp = new int[arr.length+1][arr.length+1];
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				dp[i][j] = -1;
			}
		}
		
		System.out.println(helper2(arr,dp, 1, arr.length-1));
	}
	
	
	public static int helper(int[] arr, int start, int end) {
		
		if(start>=end) {
			return 0;
		}
		int  min = Integer.MAX_VALUE;

		
		for(int k=start; k<end;k++) {
			int res = helper(arr, start, k) + helper(arr, k+1, end) + arr[start-1] * arr[k] * arr[end];
			min = Math.min(res, min);
		}
		
		return min;
	}
	
	public static int helper2(int[] arr, int[][] dp, int start, int end) {
		if(start>=end) {
			return 0;
		}
		int  min = Integer.MAX_VALUE;
		
		if(dp[start][end] !=-1) {
			return dp[start][end];
		}
		
		for(int k=start; k<end;k++) {
			int res = helper2(arr,dp, start, k) + helper2(arr,dp, k+1, end) + arr[start-1] * arr[k] * arr[end];
			min = Math.min(res, min);
		}
		dp[start][end] = min;
		return min;
	}

}
