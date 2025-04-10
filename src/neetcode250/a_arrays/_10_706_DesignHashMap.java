package neetcode250.a_arrays;

// https://leetcode.com/problems/design-hashmap/
// https://www.youtube.com/watch?v=cNWsgbKwwoU
public class _10_706_DesignHashMap {
	class MyHashMap {

		class ListNode {
			int key, val;
			ListNode next;

			public ListNode(int key, int val, ListNode next) {
				this.key = key;
				this.val = val;
				this.next = next;
			}

			public ListNode() {
				this(-1, -1, null);
			}
		}

		private ListNode[] map;

		public MyHashMap() {
			map = new ListNode[1000];
			for (int i = 0; i < 1000; i++) {
				map[i] = new ListNode();
			}
		}

		private int hash(int key) {
			return key % map.length;
		}

		public void put(int key, int value) {
			ListNode cur = map[hash(key)];
			while (cur.next != null) {
				if (cur.next.key == key) {
					cur.next.val = value;
					return;
				}
				cur = cur.next;
			}
			cur.next = new ListNode(key, value, null);
		}

		public int get(int key) {
			ListNode cur = map[hash(key)].next;
			while (cur != null) {
				if (cur.key == key) {
					return cur.val;
				}
				cur = cur.next;
			}
			return -1;
		}

		public void remove(int key) {
			ListNode cur = map[hash(key)];
			while (cur.next != null) {
				if (cur.next.key == key) {
					cur.next = cur.next.next;
					return;
				}
				cur = cur.next;
			}
		}
	}
}
