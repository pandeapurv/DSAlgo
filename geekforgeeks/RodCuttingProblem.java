package geekforgeeks;

public class RodCuttingProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 5, 8, 9, 10, 17, 17, 20}; 
		int arr2[] = {3,5,8,9,10,17,17,20};
		int price[] = new int[] {2,5,7,8}; 
	    int n = 5;
		System.out.println(helper(price,n));
	}
	
	private static int  helper(int[] prices, int lenOfRod) {
		int[][] dp = new int[prices.length+1][lenOfRod+1];
		
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				if(j >= i) {
					dp[i][j] = Math.max(dp[i-1][j], prices[i-1] + dp[i][j-i]);
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		return dp[prices.length][lenOfRod];
	}

}
