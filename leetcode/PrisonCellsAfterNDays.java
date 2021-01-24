package leetcode;
import java.util.*;
public class PrisonCellsAfterNDays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] cells = {0,1,0,1,1,0,0,1};
		prisonAfterNDays(cells, 40);
		//prisonAfterNDays2(cells,20);
	}

	public static void prisonAfterNDays(int[] cells, int N) {
		
		int k = 0;
		while(N>0) {
			System.out.print("Day"+ k++ + " : ");
			for(int c : cells) {
				System.out.print(c + ", ");
			}
			System.out.println();
			System.out.println("-------------------------------");
			
			int[] cells2 = new int[8];
			for(int i=1;i<7;i++) {
				if(cells[i-1] == cells[i+1]) cells2[i] = 1;
				else cells2[i] = 0;
			}
			cells = cells2;
			N--;
		}
	}
	
	public static int[] prisonAfterNDays2(int[] cells, int N) {
        Set<String> seen = new HashSet();
        boolean cycle = false;
        int len = 0;
        for (int i = 0; i < N; i++) {
        	System.out.print("Day"+ len + " : ");
			for(int c : cells) {
				System.out.print(c + ", ");
			}
			System.out.println();
			System.out.println("-------------------------------");
            int[] next = nextDayState(cells);
            String key = Arrays.toString(next);
            if (seen.contains(key)) {
                cycle = true;
                break;
            }
            seen.add(key);
            len++;
            cells = next;
        }

        if (cycle) {
        	System.out.println("cycle "+len);
        	return prisonAfterNDays2(cells, N % len);
        }
            
        return cells;
    }
	
	private static int[] nextDayState(int[] cells) {
        int[] next = new int[cells.length];
        for (int i = 1; i < 7; i++)
            next[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
        return next;
    }

}
