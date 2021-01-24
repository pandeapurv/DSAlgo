package leetcode;

public class TrappingRainWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(height));
	}
	
	
	public static int trap(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        int[] arr1 = new int[height.length];
        int[] arr2 = new int[height.length];
        int max = 0;
        for(int i=0;i<arr1.length;i++){
            int tmp = max;
            max = Math.max(max, height[i]);
            arr1[i] = tmp;
        }
        max = 0;
        for(int i=arr2.length-1;i>=0;i--){
        	int tmp = max;

            max = Math.max(max, height[i]);
            arr2[i] = tmp;
        }
        
        int qty = 0;
        for(int i=0;i<height.length;i++){
            int minHeight = Math.min(arr1[i],arr2[i]);
            if(minHeight > height[i]){
                qty += minHeight- height[i];
            }
        }
        
        return qty;
    }

}
