package com.google.learn.leetcode.array.easy;

import java.util.Arrays;

public class Solution {

    /**
     * 输入: [[1,1,0],[1,0,1],[0,0,0]]
     * 输出: [[1,0,0],[0,1,0],[1,1,1]]
     * 解释: 首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
     * 然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/flipping-an-image
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param A
     * @return
     */
    public int[][] flipAndInvertImage(int[][] A) {
        int temp = 0;
        int rowSize = A.length;
        for (int row = 0; row < rowSize; row++) {
            int columnSize = A[row].length;
            for (int column = 0; column < columnSize / 2.; column++) {
                A[row][column] = (A[row][column] + 1) % 2;
                A[row][columnSize - 1 - column] = (A[row][columnSize - 1 - column] + 1) % 2;
                temp = A[row][column];
                A[row][column] = A[row][columnSize - 1 - column];
                A[row][columnSize - 1 - column] = temp;
            }
            if (columnSize % 2 != 0) {
                A[row][(int) ((columnSize) / 2. - 0.5)] = (A[row][(int) ((columnSize) / 2. - 0.5)] + 1) % 2;
            }
        }
        return A;
    }


    public static int[] sortedSquares(int[] A) {
        int[] result = A;
        for (int column = 0; column < result.length; column++) {
            result[column] = result[column] * result[column];
        }
        Arrays.sort(result);
        return result;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
     *
     * 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
     *
     *
     *
     * 输入: head = [4,5,1,9], node = 5
     * 输出: [4,1,9]
     * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
     *
     * 从给定的这个结点往下传递
     * @param node
     */
    public static void deleteNode(ListNode node) {
        /**
         * 删除链表中的一个节点，老方法，需要这个节点的前节点，后节点，然后让前节点指向后节点
         * 新方法，不需要后节点，把后节点的数据放在当前节点，让当前节点指向后节点的后节点
         */
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        // head = [4,5,1,9]
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        printList(node1);
        //deleteNode(node3);
        //node1.next = node3;

        printList(reverseList(node1));
        System.out.println(reverseList(node1) == null);

    }

    private static void printList(ListNode node) {
        ListNode currentNode = node;
        while (currentNode != null) {
            System.out.print(currentNode.val + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }


    /**
     * 206. 反转链表
     反转一个单链表。

     示例:

     输入: 1->2->3->4->5->NULL
     输出: 5->4->3->2->1->NULL
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = head;


        ListNode currentNode = newHead.next;
        newHead.next = null;

        while (currentNode != null) {
            ListNode node  = new ListNode(currentNode.val);
            node.next = newHead;
            newHead = node;
            currentNode = currentNode.next;

        }
        return newHead;

    }

}
