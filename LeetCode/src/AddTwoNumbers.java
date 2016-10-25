/**
 * @author: basavakanaparthi
 * on 13,Sep,2016 at 5:14 AM.
 *
 * /

/*
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *      Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *      Output: 7 -> 0 -> 8
 */

import java.util.Scanner;

/**
 * Definition for singly-linked list.
 */

class ListNode
  {
      int val;
      ListNode next;

      ListNode(int x)
      {
          val = x;
      }

      static void printLL(ListNode head)
      {
          while (head!= null) {
              System.out.print(head.val + "-->");
              head = head.next;
          }
          System.out.print("NULL");
          System.out.println();
      }
  }


public class AddTwoNumbers
{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {

        int carryOver = 0;
        ListNode Answer = new ListNode(0);
        ListNode tmp = Answer;
        while (l1 != null || l2 != null)
        {
            int sum = 0;
            if(l1 != null && l2!=null)
            {
                sum =l1.val + l2.val + carryOver;
                l1 = l1.next;
                l2 = l2.next;
            }
            else if(l1 != null)
            {
                sum =l1.val + carryOver;
                l1 = l1.next;
            }
            else if(l2 != null)
            {
                sum =l2.val + carryOver;
                l2 = l2.next;
            }
            carryOver = 0;
            if (sum > 9)
            {
                carryOver = sum/10;
                sum = sum%10;
            }

            tmp.next = new ListNode(sum);
            tmp = tmp.next;

        }
        if (carryOver > 0)
            tmp.next = new ListNode(carryOver);
        return Answer.next;

    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        ListNode node1;
        ListNode node2;

    }
}
