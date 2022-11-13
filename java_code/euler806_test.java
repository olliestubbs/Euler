import java.util.HashMap;
public class euler806_test {
    static int g(int a, int b, int c){
        if ((a==0)&&(b==0)&&(c==0)){
            return 1;
        }
        else if((a<0)||(b<0)||(c<0)){
            return 0;
        }
        else{
            return g(a-1,c,b)+g(b,a,c-1);
        }
    }
    public static void main(String[] args){
        System.out.println(g(3,8,2));
    }
    
}
