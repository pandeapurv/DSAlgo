package leetcode;
import java.util.*;



public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Integer> set = new HashSet<>();
		
		String s1 = "c";
		String s2 = "b";
		System.out.println(s1.compareTo(s2));
		int[][] connections = new int[1][1];
		Arrays.sort(connections, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return 0;
			}
			
		});
		
		Deque<Integer> maxStack = new ArrayDeque<>();
		maxStack.addFirst(2);
		maxStack.addFirst(23);
		maxStack.addFirst(5);
		String s = "apirv";
		System.out.println(s.substring(1));
		System.out.println(Math.pow(-2, 2));
		
		System.out.println(maxStack.peekFirst());
		System.out.println(maxStack.removeFirst());
		System.out.println(maxStack.peekFirst());
		
		Queue<Integer> queue = new LinkedList<>();
		
		//queue.
		List<Integer> list = new ArrayList<>();
		//list.re
		
		String data = "";
				String[] arr = data.split(",");
		String[] arr2 = data.split("");
        
        if(arr.length == 0 || arr[0].trim().equals("")){
           // return null;
        }
        
        Map<Integer,Integer> map = new HashMap<>();
        //map.con
       
        for(Map.Entry<Integer, Integer> entryset : map.entrySet()) {
        	entryset.getKey();
        }
        int d =10;
        
        int[][] dp = new int[10][d+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        
        String w = "Bob. hIt'baLl,";
        		//String[] arr3 = w.split("\\W");
        		String[] arr3 = w.split("\\s+");
        		//.replaceAll("\\W+" , "").toLowerCase()

        		
        		for(String wd : arr3) {
        			System.out.println(wd.replaceAll("\\W+" , ""));
        		}
	}

}
