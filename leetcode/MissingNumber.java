package leetcode;

public class MissingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {9,6,4,2,3,5,7,0,1};
		System.out.println(missingNumber(arr));
	}

	public static int missingNumber(int[] nums) {

		for (int i = 0; i < nums.length; i++) {
			int val = Math.abs(nums[i]);
			if (val < nums.length && nums[val] == 0) {
				nums[val] = Integer.MAX_VALUE;
			}
			if (val < nums.length && nums[val] > 0) {
				nums[val] = -nums[val];
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == Integer.MAX_VALUE || nums[i] < 0) {
				continue;
			}
			return i;
		}
		return nums.length;
	}

}
