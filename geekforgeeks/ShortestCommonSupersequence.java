package geekforgeeks;

//https://www.geeksforgeeks.org/shortest-common-supersequence/
public class ShortestCommonSupersequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text1 = "geek";
		String text2 = "eke";
		int len = longestCommonSubsequence(text1, text2);
		System.out.println(text1.length()+text2.length()-len);
	}
	
	public static int longestCommonSubsequence(String text1, String text2) {
        if(text1 == null || text2 == null){
            return 0;
        }
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        
        return dp[text1.length()][text2.length()];
            
            
    }

}
