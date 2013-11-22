package DP.bidirections;

public class ContainerWithMostWater {
	/*
	 * move two pointers simutanously always move the smaller one each round
	 * calculate the area which height is current smaller height.
	 */
	public static int maxArea(int[] height) {
		int start = 0;
		int end = height.length - 1;
		int max = 0;
		while (start < end) {
			int h = 0;
			if (height[start] < height[end]) {
				h = height[start];
				start++;
			} else {
				h = height[end];
				end--;
			}
			// Since here start++/end--,
			// the distance reduce by 1. The true distance changes to be (end -
			// start + 1)
			max = Math.max(max, h * (end - start + 1));
		}
		return max;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = { 1, 1 };
		ContainerWithMostWater.maxArea(height);
	}
}
