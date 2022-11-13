import java.util.*;
import java.lang.Math;
public class euler423 {
    static int ext_euclid(int n){
        int t1=0;
        int t2=1;
        int a = 1000000007;
        int b = n;
        int c;
        int q;
        while (b!=0){
            q=a/b;
            c=a;
            a=b;
            b=c-q*b;
            c=t1;
            t1=t2;
            t2=c-q*t2;
        }
        return t1;
    }
    static int S(int val){
        ArrayList<Integer> primes= new ArrayList<Integer>();
        boolean isprime;
        int prime = 1000000007;
        int i;
        double root;
        int inv;
        int total=6;
        long c=6;
        long d=0;
        for (i=2;i<=val;i++){
            if ((i&0xffff)==0){
                System.out.println((i>>17));
            }
            isprime=true;
            root = Math.sqrt(i);
            for (Integer num : primes){
                if (num>root){
                    break;
                }
                else if (i%num==0){
                    isprime = false;
                }
            }
            if (isprime){
                primes.add(i);
                inv = ext_euclid(primes.size());
                d=(d*(i-2))%prime;
                d=Math.floorMod((d*inv),prime);
                c = Math.floorMod((6*c+5*d),prime);
                total = Math.floorMod(c+total,prime);
            }
            else{
                inv = ext_euclid(i-2-primes.size());
                d=(d*(i-2)*5)%prime;
                d=Math.floorMod((d*inv),prime);
                if (i==4){
                    d=6;
                }
                c = Math.floorMod((6*c-d),prime);
                total = Math.floorMod(c+total,prime);
            }
        }
        System.out.println("primes generated");
        return total;
    }
    public static void main(String[] args){
         System.out.println(S(50000000));

    }
}
