package GoDaddy;

/**
 * @author: basavakanaparthi
 * on 22,Sep,2016 at 1:56 PM.
 */
public class DeleteLL {
    class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }
    }
    public static Node removeGrtX(Node head, int x)
    {
        Node tmp = head;
        while(tmp.next != null)
        {
            if(tmp.next.data > x) {
                tmp.next = tmp.next.next;
            }
            else
                tmp = tmp.next;
        }
        if (head.data > x)
            return head.next;
        return head;
    }

    public static void main(String[] args)
    {

    }
}

