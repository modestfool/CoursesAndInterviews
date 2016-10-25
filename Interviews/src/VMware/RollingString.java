package VMware;

import java.util.Scanner;

public class RollingString {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int k = sc.nextInt();
		sc.nextLine();
		String[] ops = new String[k];
		for(int i=0; i<k ;i++){
			String op = sc.nextLine();
			ops[i] = op;
		}
		System.out.println(transform(s, ops));
		sc.close();
	}

	private static String transform(String s, String[] ops) {
		
		char[] arr = s.toCharArray();
		for(String op : ops){
			String[] parts = op.split(" ");
			int start = Integer.valueOf(parts[0]);
			int end = Integer.valueOf(parts[1]);
			String operation = parts[2];
			
			if(operation.equalsIgnoreCase("R")){
				for(int i=start; i<=end; i++)
				{
//					if(arr[i]=='z')
//						arr[i] = 'a';
//					else
						arr[i] = (char)(((int)arr[i] -(int) 'a'+ 1)%26 + (int)'a');
				}
			}
			else if(operation.equalsIgnoreCase("L")){
				for(int i=start; i<=end; i++){
//					if(arr[i]=='a')
//						arr[i] = 'z';
//					else
                    arr[i] = (char)(((int)arr[i] -(int) 'a' + 26 - 1)%26 + (int) 'a');
				}
			}
		}
		StringBuilder transformed = new StringBuilder(String.valueOf(arr));
        for (char c: arr)
            transformed.append(c);
        return String.valueOf(arr);
	}

}
