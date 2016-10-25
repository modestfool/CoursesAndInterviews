/**
 * @author: basavakanaparthi
 * on 13,Oct,2016 at 11:04 PM.
 */

import java.util.HashMap;

public class LRUCache_146
{
    class ListNode
    {
        int key;
        int val;
        ListNode next;
        ListNode prev;
        ListNode(int k, int v)
        {
            key = k;
            val = v;
        }
    }
    ListNode head;
    ListNode tail;
    HashMap<Integer, ListNode> cacheMap;
    int capacity;

    public LRUCache_146(int capacity)
    {
        this.head = null;
        this.tail = null;
        this.cacheMap = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key)
    {
        if (cacheMap.containsKey(key))
        {
            //System.out.println(key);
            ListNode curr = cacheMap.get(key);
            setHead(curr);
            return curr.val;
        }
        else
        {
            System.out.println("Else: " + key);
            return -1;
        }
    }

    public void set(int key, int value)
    {
        if (cacheMap.containsKey(key))
        {
            ListNode curr = cacheMap.get(key);
            curr.val = value;
            setHead(curr);
        }
        else
        {
            if (cacheMap.size() >= this.capacity)
                removeLRU();
            ListNode newNode = new ListNode(key, value);
            cacheMap.put(key,newNode);
            setHead(newNode);
        }
        if (head != null)
            System.out.println("Head: " + head.key);
        if (tail != null)
            System.out.println("Tail: " + tail.key);
    }

    private void setHead(ListNode node)
    {
        if (tail == null)
            tail = node;
        if (head == null)
            head = node;
        else
        {
            if(node.prev != null)
                node.prev.next = node.next;
            //else
            //  head = node.next;
            if(node.next != null)
                node.next.prev = node.prev;
            else
            {
                tail = node.prev;
            }
            node.prev = null;
            node.next = this.head;
            head = node;
        }
    }


    private void removeLRU()
    {
        if (tail == null)
        {
            head = null;
            return;
        }
        System.out.println(tail.val + ": " + tail.val);
        cacheMap.remove(tail.key);
        if(tail.prev != null)
        {
            tail.prev.next = null;
            tail = tail.prev;
        }
        else {
            tail = null;
            head = null;
        }
    }

    private void printLL()
    {
        if (head == null)
            return;
        ListNode temp = head;
        int i = 0;
        System.out.println("LL=====");
        while(temp.next != null)
        {

            System.out.print(temp.key + "-->");
            temp = temp.next;
            if (i++ > 10)
                break;
        }
        System.out.println(temp.key);
        System.out.println("LL=====");
    }
        public static void main(String[] args) {
            LRUCache_146 lru = new LRUCache_146(1);
            //System.out.println(lru.get(1));
            lru.set(2, 1);
            //lru.set(2, 11);
            //lru.set(3, 12);

            System.out.println(lru.get(2));
            lru.set(3, 2);
            //System.out.println(lru.get(3));
            System.out.println(lru.get(2));

            System.out.println(lru.get(3));
        }
    }


