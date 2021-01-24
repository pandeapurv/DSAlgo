package leetcode;
import java.util.*;
public class MergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
		
		merge(arr);
	}
	
	public static int[][] merge(int[][] intervals) {
        if(intervals == null){
            return new int[][] {};
        }
        
        if(intervals.length <= 1){
            return intervals;
        }
        
        Arrays.sort(intervals, new Comparator<int[]>(){
           public int compare(int[] a1, int[] a2){
               return a1[0] - a2[0];
           } 
        });
        
        List<int[]> res = new ArrayList<>();
        int[] curr = new int[2];
        curr[0] = intervals[0][0];
        curr[1] = intervals[0][1];
        
        for(int i=1;i<intervals.length;i++){
            int[] tmp = intervals[i];
            if(curr[1] >= tmp[0]){
                curr[1] = Math.max(curr[1],tmp[1]);
            }else{
            	
                res.add(new int[] {curr[0],curr[1]});
                curr[0] = tmp[0];
                curr[1] = tmp[1];
                if(i == intervals.length-1){
                	res.add(new int[] {curr[0],curr[1]});
                }
            }
        }
        
        int[][] arr = new int[res.size()][2];
        int k = 0;
        for(int[] t : res){
           arr[k][0] = t[0]; 
           arr[k][1] = t[1];
           k++;
        }
        
        return arr;
    }

}
