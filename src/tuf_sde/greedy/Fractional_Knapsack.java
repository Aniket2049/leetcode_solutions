package tuf_sde.greedy;

import java.util.Arrays;
import java.util.Comparator;

// https://www.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1
// https://takeuforward.org/data-structure/fractional-knapsack-problem-greedy-approach/
// https://www.youtube.com/watch?v=F_DDzYnxO14
public class Fractional_Knapsack {

	static double fractionalKnapsack(int W, Item arr[], int n) {
		Arrays.sort(arr, new itemComparator());

		int curWeight = 0;
		double finalvalue = 0.0;

		for (int i = 0; i < n; i++) {

			if (curWeight + arr[i].weight <= W) {
				curWeight += arr[i].weight;
				finalvalue += arr[i].value;
			}

			else {
				int remain = W - curWeight;
				finalvalue += ((double) arr[i].value / (double) arr[i].weight) * (double) remain;
				break;
			}
		}

		return finalvalue;

	}

	public static void main(String[] args) {
//		Example:
//		Input: N = 3, W = 50, values[] = {100,60,120}, weight[] = {20,10,30}.
//		Output: 240.00
//		Explanation: The first and second items  are taken as a whole  while only 20 units of the third item is taken. Total value = 100 + 60 + 80 = 240.00

		int n = 3, weight = 50;
		Item arr[] = { new Item(100, 20), new Item(60, 10), new Item(120, 30) };
		double ans = fractionalKnapsack(weight, arr, n);
		System.out.println("The maximum value is " + ans);
	}

}

class Item {
	int value, weight;

	Item(int x, int y) {
		this.value = x;
		this.weight = y;
	}
}

class itemComparator implements Comparator<Item> {
	@Override
	public int compare(Item a, Item b) {
		double r1 = (double) (a.value) / (double) (a.weight);
		double r2 = (double) (b.value) / (double) (b.weight);
		if (r1 < r2)
			return 1;
		else if (r1 > r2)
			return -1;
		else
			return 0;
	}
}