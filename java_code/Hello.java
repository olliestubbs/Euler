public class Hello {
    public static void main(String[] args){
        int i;
        int count=0;
        for (i=1;i<=(1<<30);i++){
            if ((i&(i<<1))==0){
                count++;
            }
        }
        System.out.println(count);
    }
}
