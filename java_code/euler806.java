import java.util.HashMap;
public class euler806 {
    static HashMap<Long,Integer> update(HashMap<Long,Integer> data, int n){
        long mask = (1L<<32)-1;
        long a;
        long b;
        long c;
        long newWord;
        int val;
        HashMap<Long,Integer> newMap = new HashMap<Long, Integer>();
        for (Long key : data.keySet()){
            a = key>>32;
            c=key&mask;
            b=(long)n-a-c;
            if ((a-1)>=0){
                newWord = ((a-1)<<32)+b;
                if (newMap.containsKey(newWord)){
                    val=newMap.get(newWord)+data.get(key);
                    if (val>=1000000007){
                        newMap.put(newWord,val-1000000007);
                    }
                    else{
                        newMap.put(newWord,val);
                    }

                }
                else{
                    newMap.put(newWord,data.get(key));
                }
            }
            if ((c-1)>=0){
                newWord = ((b)<<32)+(c-1);
                if (newMap.containsKey(newWord)){
                    val=newMap.get(newWord)+data.get(key);
                    if (val>=1000000007){
                        newMap.put(newWord,val-1000000007);
                    }
                    else{
                        newMap.put(newWord,val);
                    }
                }
                else{
                    newMap.put(newWord,data.get(key));
                }
            }
        }
        return newMap;
    }
    public static void main(String[] args){
        HashMap<Long,Integer> data = new HashMap<Long,Integer>();
        int i;
        int j;
        int k;
        int n=1000;
        int count=0;
        long word;
        for (i=0;i<=n;i++){
            for (j=0;((i+j)<=n);j++){
                k=n-i-j;
                if ((i^j^k)==0){ 
                    System.out.printf("%d,%d,%d\n",i,j,k);
                    word = (((long)i)<<32)+k;
                    data.put(word,1);
                    count++;
                }
            }
        }
        for (;n!=0;n--){
            data = update(data,n);
        }

        System.out.println(data);
    }
}
