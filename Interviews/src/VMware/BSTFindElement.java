package VMware;


public class BSTFindElement {

	public static void main(String[] args) {

		Node root = new Node(20);
		root.left = new Node(10);
		root.right = new Node(30);

		root.left.left = (new Node(8));
		root.left.right = (new Node(12));
		
		root.right.left = (new Node(25));
		root.right.right = (new Node(40));
		
		int ch = findElement(root, 25);
        System.out.println(ch);
//		if(ch)
//			System.out.println(1);
//		else
//			System.out.println(0);
	}

	private static int findElement(Node root, int i) {
		
		if(root == null)
			return 0;
		if(root.data == i)
			return 1;
        else if (root.data > i)
            return findElement(root.left, i);
        else
            return findElement(root.right, i);

	}

	static class Node{
		int data;
		Node right,left;
		Node(int data)
		{
			this.data = data;
		}

	}

}
