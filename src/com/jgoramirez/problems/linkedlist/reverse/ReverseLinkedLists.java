package com.jgoramirez.problems.linkedlist.reverse;

import com.jgoramirez.problems.linkedlist.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class ReverseLinkedLists {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode lista = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));

        solution.reverseList(lista);

    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        System.out.println(head);

        ListNode reversed = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextTemp = current.next; // Guardamos el siguiente nodo
            current.next = reversed; // Cambiamos el enlace del nodo actual para apuntar al nodo previo
            reversed = current; // Movemos previo al nodo actual
            current = nextTemp; // Movemos el nodo actual al siguiente nodo
        }

        System.out.println(reversed);

        return reversed;
    }
}

