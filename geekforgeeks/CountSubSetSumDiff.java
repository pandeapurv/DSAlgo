package geekforgeeks;

public class CountSubSetSumDiff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {1,2,3,1};
		int diff = 1;
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
		}
		int target = (diff+sum)/2;
		System.out.println(helper2(arr,target));

	}
	
	private static int helper2(int[] arr, int sum) {
		int[][] dp = new int[arr.length+1][sum+1];
		dp[0][0] =1;
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
