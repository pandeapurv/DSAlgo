package leetcode;

public class BestTimetoBuyandSellStockII_L122 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		maxProfit(prices);
	}

	public static int maxProfit(int[] prices) {
		int Tik0 = 0;
		int Tik1 = Integer.MIN_VALUE;

		for (int price : prices) {
			int Tik0Old = Tik0;
			System.out.println();
			System.out.println("-------------------------");
			//System.out.print("Tik0Old: " + Tik0Old + " ; ");
			Tik0 = Math.max(Tik0, Tik1 + price);
			System.out.print("Tik0: " + Tik0 + " ; ");
			Tik1 = Math.max(Tik1, Tik0Old - price);
			System.out.print("Tik1: " + Tik1 + " ; ");
		}

		return Tik0;
	}

}
