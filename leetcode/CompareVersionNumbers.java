package leetcode;

public class CompareVersionNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(compareVersion("7.5.2.4","7.5.3"));
	}
	
	public static int compareVersion(String version1, String version2) {
        if(version1 == null || version2==null ){
            return 0;
        }
        
        String[] arr1 = version1.split(".");
        String[] arr2 = version2.split(".");
        
        int index = 0;
        while(index < arr1.length && index < arr2.length){
            int t1 = Integer.valueOf(arr1[index]);
            int t2 = Integer.valueOf(arr2[index]);
            if(t1 < t2){
                return -1;
            }else if(t1 > t2){
                return 1;
            }
            index++;
        }
        
        if(index == arr1.length && index == arr2.length){
            return 0;
        }
        
        if(index == arr1.length){
            while(index < arr2.length){
                int t = Integer.valueOf(arr2[index]);
                if(t>0){
                    return -1;
                }
                index++;
            }
            
        }else{
             while(index < arr1.length){
                int t = Integer.valueOf(arr1[index]);
                if(t>0){
                    return 1;
                }
                index++;
            }

        }
        
        return 0;
        
    }

}
