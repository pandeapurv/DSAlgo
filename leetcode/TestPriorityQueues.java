package leetcode;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.ArrayList;

public class TestPriorityQueues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<>();
		Iterator<Integer> itr = arr.iterator();
		
		//testminPQMap();
		testMaxPQ();
	}
	
	public static void testminPQ() {
		
		PriorityQueue<Integer> minPQ = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1-o2;
			}
			
		});
		
		minPQ.add(1);
		minPQ.add(10);
		minPQ.add(50);
		minPQ.add(15);
		
		while(!minPQ.isEmpty()) {
			System.out.println(minPQ.poll());
		}
	}
	
	public static void testMaxPQ() {
		
		PriorityQueue maxPQ = new PriorityQueue<>(new Comparator<Integer>() {
			
			public int compare(Integer o1, Integer o2) {
				//System.out.println(o2 - o1);
				//return o2 - o1;
				if(o2>o1) {
					return 1;
				}else if(o2 == o1) {
					return 0;
				}else {
					return -1;
				}
			}
		});
		
		maxPQ.add(1);
		maxPQ.add(10);
		maxPQ.add(50);
		maxPQ.add(15);
		while(!maxPQ.isEmpty()) {
			System.out.println(maxPQ.poll());
		}
	}
	
	public static void testminPQMap() {
		
		PriorityQueue<Map.Entry<String, Integer>> minPQ = new PriorityQueue<>(
				new Comparator<Map.Entry<String, Integer>>(){
					
					public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
						
						if(o1.getValue() == o2.getValue()) {
							return o1.getKey().compareTo(o2.getKey());
						}
						return o1.getValue() - o2.getValue();
						
					}
				});
		
		Map<String, Integer> map = new HashMap<>();
		
		map.put("apurv", 2);
		map.put("pande", 1);
		map.put("skjdf", 10);
		map.put("skjdfs", -1);
		
		
		for(Map.Entry<String, Integer> entrySet : map.entrySet()) {
			minPQ.add(entrySet);
		}
		
		while(!minPQ.isEmpty()) {
			System.out.println(minPQ.poll().getKey());
		}
	}

}
