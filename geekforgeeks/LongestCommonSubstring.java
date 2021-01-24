package geekforgeeks;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1 = "GeeksforGeeks";
		String s2 = "GeeksQuiz";
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		
		int max = 0;
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					dp[i][j] = 1 + dp[i-1][j-1];
					max = Math.max(max,dp[i][j]);
				}
			}
		}
		
		System.out.println(max);

	}

}
