package priorityqueues;

import java.util.*;

public class PQ {
    public static void main(String[] args) {
        int[] arr = {15,12,17,18,11,13,14,16,18,19};
        System.out.println(kthLargest(arr.length, arr,3));

    }

    /*****************************************************************************************************************/
    /*Time To Buy the ticket

    You want to buy a ticket for a well-known concert which is happening in your city. But the number of tickets available is limited. Hence the sponsors of the concert decided to sell tickets to customers based on some priority.
    A queue is maintained for buying the tickets and every person is attached with a priority (an integer, 1 being the lowest priority).
    The tickets are sold in the following manner -
    1. The first person (pi) in the queue requests for the ticket.
    2. If there is another person present in the queue who has higher priority than pi, then ask pi to move at end of the queue without giving him the ticket.
    3. Otherwise, give him the ticket (and don't make him stand in queue again).
    Giving a ticket to a person takes exactly 1 second and it takes no time for removing and adding a person to the queue. And you can assume that no new person joins the queue.
    Given a list of priorities of N persons standing in the queue and the index of your priority (indexing starts from 0). Find and return the time it will take until you get the ticket.
    Input Format:
    The first line of input contains an integer, that denotes the value of total number of people standing in queue or the size of the array of priorities. Let us denote it with the symbol N.
    The following line contains N space separated integers, that denote the value of the elements of the array of priorities.
    The following contains an integer, that denotes the value of index of your priority. Let us denote it with symbol k.
    Output Format :
    The first and only line of output contains the time required for you to get the ticket.
    Constraints:
    Time Limit: 1 sec
    Sample Input 1 :
    3
    3 9 4
    2
    Sample Output 1 :
    2
    Sample Output 1 Explanation :
    Person with priority 3 comes out. But there is a person with higher priority than him. So he goes and then stands in the queue at the end. Queue's status :  {9, 4, 3}. Time : 0 secs.
    Next, the person with priority 9 comes out. And there is no person with higher priority than him. So he'll get the ticket. Queue's status :  {4, 3}. Time : 1 secs.
    Next, the person with priority 4 comes out (which is you). And there is no person with higher priority than you. So you'll get the ticket. Time : 2 secs.
    Sample Input 2 :
    5
    2 3 2 2 4
    3
    Sample Output 2 :
    4
    */
    public static int buyTicket(int[] input, int k) {
        Queue<Integer> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : input) {
            q.add(i);
            pq.add(i);
        }
        int count = 0;
        while (!pq.isEmpty()) {
            if (Objects.equals(q.peek(), pq.peek())) {
                if (k == 0) {
                    return count + 1;
                } else {
                    pq.poll();
                    q.poll();
                    count++;
                    k--;
                }
            } else {
                q.add(q.peek());
                q.poll();

                if (k == 0) {
                    k = q.size() - 1;
                } else {
                    k--;
                }

            }
        }
        return count;
    }

    /*****************************************************************************************************************/
    /* Given an array A of random integers and an integer k,
    find and return the kth largest element in the array.
      Note: Try to do this question in less than O(N * logN) time.*/
    public static int kthLargest(int n, int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }
        for (int i = k; i < n; i++) {
            if (nums[i] < minHeap.peek()) {
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
        return minHeap.peek();
    }

    /*****************************************************************************************************************/
    /* Check Max-Heap
    Send Feedback
    Given an array of integers, check whether it represents max-heap or not. Return true if the given array represents max-heap, else return false.
    Input Format:
        The first line of input contains an integer, that denotes the value of the size of the array. Let us denote it with the symbol N.
    The following line contains N space separated integers, that denote the value of the elements of the array.
    Output Format :
    The first and only line of output contains true if it represents max-heap and false if it is not a max-heap.
    Constraints:
    1 <= N <= 10^5
    1 <= Ai <= 10^5
    Time Limit: 1 sec
    Sample Input 1:
    8
    42 20 18 6 14 11 9 4
    Sample Output 1:
    true
    */
    public static boolean checkMaxHeap(int arr[]) {
        int parentIndex = 0;
        int leftChildIndex = (2 * parentIndex) + 1;
        int rightChildIndex = (2 * parentIndex) + 2;
        while (leftChildIndex < arr.length) {
            if (arr[parentIndex] < arr[leftChildIndex]) {
                return false;
            }
            if (arr[parentIndex] < arr[rightChildIndex]) {
                return false;
            }
            parentIndex = leftChildIndex;
            leftChildIndex = (2 * parentIndex) + 1;
            rightChildIndex = (2 * parentIndex) + 2;
        }
        return true;
    }

    /*****************************************************************************************************************/
    /* You are given with an integer k and an array of integers that contain numbers in random order.
    Write a program to find k largest numbers from given array.
    You need to save them in an array and return it.
    Time complexity should be O(nlogk) and space complexity should be not more than O(k).*/
    public static ArrayList<Integer> kLargest(int[] input, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            System.out.println(input[i]);
            pq.add(input[i]);
        }

        for (int i = k; i < input.length; i++) {
            if (pq.peek() > input[i]) {
                pq.add(input[i]);
                pq.remove();
            }
        }
        while (!pq.isEmpty()) {
            ans.add(pq.remove());
        }
        return ans;
    }

    /*****************************************************************************************************************/
    /* You are given with an integer k and an array of integers that contain numbers in random order.
    Write a program to find k smallest numbers from given array.
    You need to save them in an array and return it.
    Time complexity should be O(nlogk) and space complexity should be not more than O(k).*/
    public static ArrayList<Integer> kSmallest(int n, int[] input, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        Arrays.sort(input);
        for (int i = 0; i < k; i++) {
            ans.add(input[i]);
        }
        return ans;
    }
}
