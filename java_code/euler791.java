public class euler791{
    static int S(int n){
        int i,j,k,l;
        int total=0;
        int sum;
        int square;
        for (i=1;i<n;i++){
            for (j=i;j<n;j++){
                for (k=j;k<n;k++){
                    for (l=k;l<n;l++){
                        sum = i+j+k+l;
                        square = i*i+j*j+k*k+l*l;
                        if ((4*square-sum*sum-2*sum)==0){
                            total=total+sum;
                        }
                    }
                }
            }
        }
        return total;
    }
    public static void main(String[] args){
        int n;
        for (n=1;n<30;n++){
            System.out.println(S(n));
        }
    }
}
