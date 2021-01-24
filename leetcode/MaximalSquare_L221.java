package leetcode;

import java.util.HashSet;
import java.util.Set;

public class MaximalSquare_L221 {

	static int maxArea = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] matrix = new char[1][1];
		Set<Integer> set = new HashSet<>();
		String s = "panapurv";
		s.matches("apurv");
		System.out.println(s.matches("apurv"));
		//matrix[0][0]=;
		/*if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }*/
//        helper(matrix, matrix.length-1,matrix[0].length-1);
//        System.out.println(maxArea);
	}
	
	private static int helper(char[][] matrix, int r, int c){

        int rightOnes = 0;
        for(int i=r;i>=0;i--){
            for(int j=c;j>=0;j--){
                if(matrix[i][j] == '1'){
                    maxArea = Math.max(maxArea,1);
                    rightOnes = helper2(matrix,i,j+1);
                    int min = Integer.MAX_VALUE;
                    int row = 0;
                    for(int k=i+1;k<=rightOnes && k< matrix.length;k++){
                        min = Math.min(min,helper2(matrix,k,j));
                        row++;
                        if(min < rightOnes){                            
                            break;                            
                        }
                    }
                    int dimension = Math.min(rightOnes,row)+1;
                    maxArea = Math.max(maxArea,dimension*dimension);
                    
                }
            }
        }
        return rightOnes;
    }
    
    private static int helper2(char[][] matrix, int r, int c){
        if(r<0 || c<0 || r>=matrix.length || c>= matrix[0].length ||
          matrix[r][c] == '0'){
            return 0;
        }
        
        int count = 0;
        for(int i=c;i<matrix[0].length;i++){
            if(matrix[r][i] == '0'){
                break;
            }
            count++;
        }
        
        return count;
    }

}
