package com.LeetCode.Easy11;

import java.util.HashMap;

public class P705_DesignHashSet {
    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        System.out.println(hashSet.contains(1)+"|"+hashSet.contains(3));
        hashSet.add(2);
        System.out.println(hashSet.contains(2));    // returns true
        hashSet.remove(2);
        System.out.println(hashSet.contains(2));  // returns false (already removed)
    }
}
class MyHashSet {
    // 底层使用HashMap来保存HashSet中所有元素。
    private transient HashMap<Integer,Object> map;
    // 定义一个虚拟的Object对象作为HashMap的value，将此对象定义为static final。
    private static final Object PRESENT = new Object();
    /** Initialize your data structure here. */
    public MyHashSet() {
        map = new HashMap<>();
    }
    public void add(int key) {
        map.put(key, PRESENT);
    }
    public void remove(int key) {
        map.remove(key);
    }
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return  map.containsKey(key);
    }
}