package leetcode;
//https://leetcode.com/problems/longest-common-subsequence/
//https://www.geeksforgeeks.org/printing-longest-common-subsequence/
public class LongestCommonSubSeq_L1143 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		printLCS("AGGTAB","GXTXAYB");
		StringBuilder sb = new StringBuilder();
		
		printLongestCommonSubsequence("AGGTAB","GXTXAYB");

	}
	
	public int longestCommonSubsequence(String text1, String text2) {
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
	
	public static void printLongestCommonSubsequence(String text1, String text2) {
        if(text1 == null || text2 == null){
            return ;
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
        
       StringBuilder sb = new StringBuilder();
       
       int i = dp.length -1;
       int j = dp[0].length -1;
       
       while(i >0 && j>0) {
    	   if(text1.charAt(i-1) == text2.charAt(j-1)) {
    		   sb.append(text1.charAt(i-1));
    		   i--;
    		   j--;
    	   }else {
    		   if(dp[i-1][j] > dp[i][j-1]) {
    			   i--;
    		   }else {
    			   j--;
    		   }
    	   }
       }
       System.out.println(sb.reverse());
       
            
            
    }
	
	public static void printLCS(String text1, String text2) {
        if(text1 == null || text2 == null){
            return ;
        }
        
       
        
        String[][] dp= new String[text1.length()+1][text2.length()+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
            	if(i ==0 || j==0) {
            		dp[i][j] = "";
            	}else {
            		if(text1.charAt(i-1) == text2.charAt(j-1)){
                        dp[i][j] =   dp[i-1][j-1] + text1.charAt(i-1);
                    }else{
                        if(dp[i-1][j].length() > dp[i][j-1].length()) {
                        	dp[i][j] = dp[i-1][j];
                        }else {
                        	dp[i][j] = dp[i][j-1];
                        }
                    }
            	}
                
            }
        }
        
        System.out.println(dp[text1.length()][text2.length()]);
	}

}
