package com.learn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

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
     * <p>
     * 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
     * <p>
     * <p>
     * <p>
     * 输入: head = [4,5,1,9], node = 5
     * 输出: [4,1,9]
     * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
     * <p>
     * 从给定的这个结点往下传递
     *
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

    public static void main1(String[] args) {
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

        //printList(reverseList(node1));
        //System.out.println(reverseList(node1) == null);
        //System.out.println(middleNode(node1).val);
        printList(removeNthFromEnd(node4, 1));

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
     * 反转一个单链表。
     * <p>
     * 示例:
     * <p>
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = head;


        ListNode currentNode = newHead.next;
        newHead.next = null;

        while (currentNode != null) {
            ListNode node = new ListNode(currentNode.val);
            node.next = newHead;
            newHead = node;
            currentNode = currentNode.next;

        }
        return newHead;

    }

    public static ListNode middleNode(ListNode head) {
        /*
        if (head == null) {
            return null;
        }

        ListNode currentNode = head;
        int length = 0;
        while (currentNode != null) {
            length++;
            currentNode = currentNode.next;
        }

        ListNode result = null;
        int count = 0;
        currentNode = head;
        while (currentNode != null) {

            if (count == length / 2) {
                result = currentNode;
            }
            count++;
            currentNode = currentNode.next;
        }
        return result;
        */

        /*
        ListNode currentNode = head;
        List<ListNode> list = new ArrayList<>();
        while (currentNode != null) {
            list.add(currentNode);
            currentNode = currentNode.next;
        }
        ((ArrayList<ListNode>) list).trimToSize();
        return list.get(list.size() / 2);
        */

        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null) {

            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>();
        ListNode currentNode = head;
        while (currentNode != null) {
            list.add(currentNode);
            currentNode = currentNode.next;
        }

        ((ArrayList<ListNode>) list).trimToSize();
        ListNode nthFromEnd = list.get(list.size() - n);


        if (nthFromEnd.next == null /*&& list.size() > 1*/) {
            nthFromEnd = null;
            //list.get(list.size() - 2).next = null;
        } else {
            nthFromEnd.val = nthFromEnd.next.val;
            nthFromEnd.next = nthFromEnd.next.next;
        }
        return list.get(0);

    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val != val && head.next == null) {
            return head;
        }
        ListNode curr = head.next;
        ListNode front = head;
        while (curr != null) {
            if (curr.next != null) {
                if (curr.val == val) {
                    curr.val = curr.next.val;
                    curr.next = curr.next.next;
                } else {
                    front = front.next;
                    curr = curr.next;
                }
            } else {
                if (curr.val == val) {
                    front.next = null;
                }
                curr = null;
            }
        }

        if (head.val == val) {
            if (head.next != null) {
                head.val = head.next.val;
                head.next = head.next.next;
            } else {
                head = null;
            }
        }
        return head;
    }

    private void traverseList(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            int val = cur.val;
            cur = cur.next;
        }
    }

    private void traverseListWithDoubleSpeed(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next.next != null) {
            int val = cur.val;
            cur = cur.next.next;
        }
    }

    private ListNode getMiddleNode(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode getNthNodeFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }

        ListNode slow = head, fast = head;

        while (n > 0 && fast != null) {
            fast = fast.next;
            n--;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow.next;
    }

    private ListNode mergetwoLists(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(-1);
        ListNode dummy = temp;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
                temp = temp.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
                temp = temp.next;
            }
        }

        if (l1 == null) {
            temp.next = l2;
        }
        if (l2 == null) {
            temp.next = l1;
        }

        return dummy.next;
    }

    public static void main2(String[] args) {
//4->2->1->3
        ListNode head = new ListNode(4);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        node3.next = null;
        node2.next = node3;
        node1.next = node2;
        head.next = node1;
        head = insertionSortList(head);

        ListNode cur = head;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }


    }

    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 定义三个指针 pre, cur, lat
        //pre    cur    lat
        // dummy  ->  4  ->  2  ->  5  ->  3  ->  null

        // 创建 dummy 节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode lat;

        while (cur != null) {
            lat = cur.next;

            if (lat != null && lat.val < cur.val) {

                // 停下来时，让pre在lat的前面，就方便插入
                while (pre.next != null && pre.next.val < lat.val) {
                    pre = pre.next;
                }

                ListNode tmp = pre.next;
                pre.next = lat;
                cur.next = lat.next;
                lat.next = tmp;
                pre = dummy;
            } else {
                cur = lat;
            }
        }

        return dummy.next;

    }

    private ListNode reverseList1(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode a = head, b = head.next;
        // a --> b --> c

        while (b != null) {
            ListNode c = b.next;

            b.next = a;
            a = b;
            b = c;
        }

        head.next = null;
        return a;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void quickSort1(int[] arr, int l, int r) {
        if (l >= r) return;
        int pivot = arr[new Random().nextInt(l - r) + l];
        int i = l - 1;
        int j = r + 1;

        while (i < j) {
            do i++; while (arr[i] < pivot);
            do j--; while (arr[j] > pivot);
            if (i < j) swap(arr, i, j);
        }
        quickSort1(arr, l, j);
        quickSort1(arr, j + 1, r);
    }

    private void mergeSort(int[] arr, int l, int r) {
        if (l >= r) return;

        int mid = l + r >> 1;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        int k = 0;
        int i = l;
        int j = mid + 1;
        int[] temp = new int[arr.length];
        while (i <= mid && j <= r) {
            if (arr[i] <= arr[j]) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= r) temp[k++] = arr[j++];

        for (i = l, j = 0; i <= r; i++, j++) {
            arr[i] = temp[j];

        }
    }

    public int climbStairs(int n) {
        if (n < 1) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        int a = 1;
        int b = 2;
        int temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }

        return temp;
    }

    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int last = 0;
        for (int i = 0; i < nums.length; i++) {
            int now = Math.max(last, 0) + nums[i];
            res = Math.max(res, now);
            last = res;
        }
        return res;
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        long[][] f = new long[n][triangle.get(n - 1).size()];
        f[0][0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                f[i][j] = Integer.MAX_VALUE;
                if (j > 0) f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + triangle.get(i).get(j));
                if (j < i) f[i][j] = Math.min(f[i][j], f[i - 1][j] + triangle.get(i).get(j));
            }
        }

        long res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, f[n - 1][i]);
        }

        return (int) res;
    }

    public int mySqrt(int x) {
        double l = 0, r = x;

        double mid = 0;
        while (Math.abs(l - r) > 1e-6) {
            mid = (l + r) / 2;
            if (Math.pow(mid, 2) > 0) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return (int) mid;
    }

    public boolean isValidBST(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    //每个节点，传一个区间下来
    private boolean dfs(TreeNode root, long minValue, long maxValue) {
        if (root == null) return true;

        if (root.val < minValue || root.val > maxValue) return false;

        return dfs(root.left, minValue, root.val - 1L) &&
                dfs(root.right, root.val + 1L, maxValue);
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();

        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }

            p = stack.pop();
            res.add(p.val);
            p = p.right;
        }

        return res;
    }

    private void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int index = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    index = j;
                }
            }
            swap(arr, i, index);
        }
    }

    private void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    private static boolean isPalindromic(String s) {
        char[] chs = s.toCharArray();
        int left = 0, right = chs.length - 1;
        while (left < right) {
            if (chs[left] != chs[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public String longestPalindrome(String s) {
        String ans = "";
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                String test = s.substring(i, j);
                if (isPalindromic(test) && test.length() > max) {
                    ans = test;
                    max = test.length();
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(-1 / 2);
    }

    public static boolean isPalindrome(String s) {
        if (s == null) return false;
        if (s.length() == 0) return true;
        char[] chs = s.toLowerCase().toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char ch : chs) {
            if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
                sb.append(ch);
            }
        }
        System.out.println(sb.toString());

        chs = sb.toString().toCharArray();
        int left = 0, right = chs.length - 1;
        while (left < right) {
            if (chs[left] != chs[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String s = x + "";

        char[] chs = s.toCharArray();
        int left = 0, right = chs.length - 1;
        while (left < right) {
            if (chs[left] != chs[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int maxSubstringLength = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (allUnique(s, i, j)) maxSubstringLength = Math.max(maxSubstringLength, j - i);
            }
        }
        return maxSubstringLength;
    }

    private boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        Character ch;
        for (int i = start; i < end; i++) {
            ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }

    private void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) return;

        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }

        int heapSize = arr.length;
        swap(arr, 0, --heapSize); // 大根堆的根与最后一个元素交换，并且堆的大小减1，不再动堆上的这个元素

        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
        System.out.println(Arrays.toString(arr));

    }

    private void heapify(int[] arr, int index, int heapSize) {
        int left = 2 * index + 1;
        while (left < heapSize) {
            // left + 1是右孩子，下面是比较左右哪个孩子大，largest记录大的孩子的下标
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;

            // 将左右孩子中较大的与父节点比较，记录较大的节点的下标
            largest = arr[largest] > arr[index] ? largest : index;

            // 如果较大的节点就是父节点，跳出循环
            if (largest == index) break;

            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    // 建立大根堆
    private void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    private void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) return;

        for (int i = 0; i < arr.length; i++) {
            heapInset(arr, i);
        }

        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    private void heapify(int[] arr, int index, int heapSize) {
        int left = 2 * index + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }

            swap(arr, index, largest);
            index = largest;
            left = 2 * index + 1;
        }
    }

    private void heapInset(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }


    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



}