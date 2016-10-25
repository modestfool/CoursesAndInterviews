package IBM;

import java.util.Scanner;

/**
 * @author: basavakanaparthi
 * on 21,Oct,2016 at 10:56 PM.
 */
public class OutThink {

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        String s =scanner.nextLine();
        String[] parts = s.split(" ");
        int N = Integer.parseInt(parts[0]);
        int p= Integer.parseInt(parts[1]);
        int q=Integer.parseInt(parts[2]);

        for(int i=1;i<=N;i++){
            if(((i%p==0) || (i%q==0)) && (containsDigit(i,p,q))){
                System.out.print("OUTTHINK");
            } else if((i%p==0) || (i%q==0)){
                System.out.print("OUT");
            } else if(containsDigit(i,p,q)){
                System.out.print("THINK");
            } else {
                System.out.print(i);
            }
            if(i < N)
                System.out.print(",");
        }
        scanner.close();
    }

    public static Boolean containsDigit(int i,int p, int q) {
        while(i>0){
            int x=i%10;
            if(x==p || x==q){
                return true;
            }
            i=i/10;
        }
        return false;
    }
}
