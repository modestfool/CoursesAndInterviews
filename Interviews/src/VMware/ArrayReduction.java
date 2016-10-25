package VMware;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ArrayReduction {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] num = new int[n];
		for(int i=0; i<n;i++){
			num[i] = sc.nextInt();
		}
		System.out.println(reduce2(num));
		sc.close();
	}

	private static int reduce(int[] num) {
		
	        int cost = 0;
			Arrays.sort(num);
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int i : num){
				list.add(i);
			}
			
			while(list.size()>1){
				int first = list.get(0);
				int second = list.get(1);
	            int sum = first + second;
	                
				list.remove(new Integer(first));
				list.remove(new Integer(second));
				cost += sum;
				list.add(sum);
				Collections.sort(list);
			}
		
			return cost;
	}
	private static int reduce2(int[] num) {

		int cost = 0;
		Arrays.sort(num);

		for (int i = 0; i < num.length; i++)
		{
			cost += (num.length-i)*num[i];
		}
//		System.out.println();
		return cost;
	}
}
