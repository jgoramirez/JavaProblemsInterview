package com.jgoramirez.problems.linkedlist;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public int getVal() {
        return val;
    }

    @Override
    public String toString() {
        return "" + val  + (next != null ? "->" + next : "");
    }
}