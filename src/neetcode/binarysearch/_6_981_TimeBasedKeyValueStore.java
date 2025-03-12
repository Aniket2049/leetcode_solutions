package neetcode.binarysearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/time-based-key-value-store/
// https://www.youtube.com/watch?v=kZAZqn_J8Fo
// https://www.youtube.com/watch?v=fu2cD_6E8Hw
public class _6_981_TimeBasedKeyValueStore {

	public static void main(String[] args) {
	}

}

class TimeMap {

	private Map<String, List<Data>> map;

	public TimeMap() {
		this.map = new HashMap<>();
	}

	public void set(String key, String value, int timestamp) {
		if (!map.containsKey(key)) {
			map.put(key, new ArrayList<TimeMap.Data>());
		}
		map.get(key).add(new Data(value, timestamp));
	}

	public String get(String key, int timestamp) {
		if (!map.containsKey(key))
			return "";

		List<Data> keyData = map.get(key);
		int left = 0;
		int right = keyData.size() - 1;
		while (left < right) {
			int mid = (left + right + 1) / 2;

			if (keyData.get(mid).timestamp <= timestamp) {
				left = mid;
			} else {
				right = mid - 1;
			}
		}
		Data closestData = keyData.get(left);
		return closestData.timestamp > timestamp ? "" : closestData.value;
	}

//	private String findClosestTimestampValue(List<Data> keyData, int timestamp) {
//
//	}

	class Data {
		String value;
		int timestamp;

		public Data(String value, int timestamp) {
			super();
			this.value = value;
			this.timestamp = timestamp;
		}
	}
}