package VMware;

import java.util.Scanner;

public class MergeStrings {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String first = sc.nextLine();
		String second = sc.nextLine();
		String out = merge(first, second);
		System.out.println(out);
		sc.close();
	}

	private static String merge(String first, String second) {
		StringBuilder merged = new StringBuilder();
		char[] a = first.toCharArray();
		char[] b = second.toCharArray();
		int i=0, j=0;
		
		for(; i<a.length && j<b.length;)
		{
			merged.append(a[i++]);
			merged.append(b[j++]);
		}
        if(i<a.length)
            merged.append(a, i,a.length-i);
		if(j< b.length){
			merged.append(b, j, b.length - j);
		}
		return merged.toString();
	}

}
