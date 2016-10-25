package VMware;

import java.util.Scanner;

public class Chocolates {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] arr = new int[T];
		for(int i=0; i<T; i++){
			arr[i] = sc.nextInt();
		}
		calculate(arr);
		sc.close();
	}

	private static void calculate(int[] arr) {

//		int arr_max = Integer.MIN_VALUE;
//
//        for(int i : arr){
//            if(i > arr_max)
//                arr_max = i;
//        }
//        long[] costs = new long[arr_max+1];
//        long ans = 0;
//        for(int i=1; i<=arr_max; i++){
//            if(i%2 !=0){
//                ans += i;
//            }
//            costs[i] = ans;
//        }

        for (int anArr : arr) {
//            long n = costs[anArr];
            long n = anArr/2 + anArr%2;
            System.out.println(n*n);
        }
	}

}
