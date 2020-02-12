package com.LeetCode.Easy11;

public class P706_DesignHashMap {
    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        System.out.println(
                hashMap.get(1) + "|" + hashMap.get(3)
        );
        hashMap.put(2, 1);
        System.out.println(hashMap.get(2));
        hashMap.remove(2);
        System.out.println(hashMap.get(2));
    }
    static class MyHashMap {
        final ListNode[] buckets = new ListNode[10000];
        /** Initialize your data structure here. */
        public MyHashMap() {
        }
        /** value will always be non-negative. */
        public void put(int key, int value) {
            int i = hash(key);
            if (buckets[i] == null)
                buckets[i]=new ListNode(-1,-1);
            ListNode prev = findPre(buckets[i], key);
            if (prev.next == null) {
                prev.next = new ListNode(key, value);
            }
            else prev.next.val = value;
        }
        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            int i = hash(key);
            if (buckets[i] == null) {
                return -1;
            }
            ListNode prev = findPre(buckets[i], key);
            return prev.next == null ? -1 : prev.next.val;
        }
        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            int i = hash(key);
            if (buckets[i]==null) return;
            ListNode prev = findPre(buckets[i], key);
            if (prev.next==null) return;
            prev.next = prev.next.next;
        }
        int hash(int key){
            return Integer.hashCode(key) % buckets.length;
        }
        ListNode findPre(ListNode bucket, int key) {
            ListNode node = bucket;
            ListNode prev = null;
            while (node != null && node.key != key) {
                prev = node;
                node = node.next;
            }
            return prev;
        }
        class ListNode {
            int key,val;
            ListNode next;
            ListNode(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }
    }
}
