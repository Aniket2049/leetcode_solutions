package neetcode250.d_stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/maximum-frequency-stack/
// https://www.youtube.com/watch?v=Z6idIicFDOE
// https://algo.monster/liteproblems/895
public class _14_895_MaximumFrequencyStack {
	class FreqStack {

		// A map to store the frequency of each element.
		private Map<Integer, Integer> frequencyMap = new HashMap<>();
		// A map to store stacks corresponding to each frequency.
		private Map<Integer, Deque<Integer>> frequencyStackMap = new HashMap<>();
		// Variable to store the current maximum frequency.
		private int maxFrequency;

		// Constructor for the FreqStack class.
		public FreqStack() {
			// Initialize the maxFrequency to 0.
			maxFrequency = 0;
		}

		// Method to push an integer onto the stack.
		public void push(int val) {
			// Increase the frequency of the value by 1.
			frequencyMap.put(val, frequencyMap.getOrDefault(val, 0) + 1);
			// Get the updated frequency of the value.
			int currentFrequency = frequencyMap.get(val);
			// Add the value to the stack corresponding to its frequency.
			frequencyStackMap.computeIfAbsent(currentFrequency, k -> new ArrayDeque<>()).push(val);
			// Update the maxFrequency if necessary.
			maxFrequency = Math.max(maxFrequency, currentFrequency);
		}

		// Method to pop and return the most frequent element from the stack.
		// If there is a tie, it returns the element closest to the stack's top.
		public int pop() {
			// Pop the element from the stack with the maximum frequency.
			int value = frequencyStackMap.get(maxFrequency).pop();
			// Decrement the frequency count of the popped element.
			frequencyMap.put(value, frequencyMap.get(value) - 1);
			// If the stack corresponding to the maximum frequency is empty,
			// then reduce the maximum frequency.
			if (frequencyStackMap.get(maxFrequency).isEmpty()) {
				maxFrequency--;
			}
			// Return the popped element.
			return value;
		}
	}
}
