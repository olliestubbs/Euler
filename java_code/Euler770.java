import java.util.*;
import java.lang.Math;
public class Euler770 {
    static double f(double a, double b){
        return (2*a*b)/(a+b);
    }
    static double logf(double a, double b){
        return (Math.log(2)+a-Math.log(1+Math.exp(a-b)));
    }
    static int g(double  x){
        double target = 1/(2-x)-0.5;
        double current = 1;
        int n;
        for (n=2;n<(1<<28);n++){
            current=current*((double)2*n/(2*n-1));
            if (current>=target){
                return n;
            }
        }
        return 0;
    }
    public static void main(String[] args){
        System.out.println(g(1.9999));
    }
}
