package com.jgoramirez.problems.linkedlist.cycle;

import com.jgoramirez.problems.linkedlist.ListNode;
public class LinkedListCycle {

    public static void main(String[] args) {

        Solution solution = new Solution();
        ListNode lista = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);

        // Enlazamos los nodos
        lista.next = node1;
        node1.next = node2;
        node2.next = node3;
        // Establecemos el enlace del último nodo al nodo en la posición 1
        node3.next = node1;

        System.out.println(solution.hasCycle(lista));

        ListNode lista2 = new ListNode(1);
        ListNode node4 = new ListNode(2);

        lista2.next = node4;
        node4.next = lista2;

        System.out.println(solution.hasCycle(lista2));

        ListNode lista3 = new ListNode(1);

        System.out.println(solution.hasCycle(lista3));


    }

}

class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode tortoise = head;
        ListNode hare = head;

        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;

            if (tortoise == hare) {
                return true;
            }
        }

        return false;
    }
}

