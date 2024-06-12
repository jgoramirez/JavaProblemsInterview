package com.jgoramirez.problems.linkedlist.doublelist;

import com.jgoramirez.problems.linkedlist.ListNode;

public class DoubleLinkedList {

    DoubleLinkedList prev;
    DoubleLinkedList next;
    int val;
    int length;

    public DoubleLinkedList(int val) {
        this.val = val;
        this.length = 1;
    }

    public DoubleLinkedList(int val, DoubleLinkedList next) {
        DoubleLinkedList dll = new DoubleLinkedList(val);
        length++;

    }

    public DoubleLinkedList prepend(int val) {
        DoubleLinkedList start = new DoubleLinkedList(val);
        start.next = next;
        start.prev = prev;

        return start;
    }

    public DoubleLinkedList append(int val) {
        DoubleLinkedList next = new DoubleLinkedList(val);

        return next;
    }

    public void delete(DoubleLinkedList item) {

    }

    public void search(int val) {

    }

    public int getLenght() {
        return length;
    }

    @Override
    public String toString() {
        return ""+this.val + (this.next != null ? this.next.val : "");
    }

    public String reverseString() {
        return super.toString();
    }

}
