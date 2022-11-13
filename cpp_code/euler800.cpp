#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

class prime_space{
    private:
        vector<unsigned int> primes;
        vector<double> log_primes;
        unsigned long count;
        int cut_off = 800;
        unsigned int i;
        bool is_prime;
        double root;
        double log2 = log(2);
    public:
        double log_target;
        prime_space(double log_targ){
            log_target=log_targ;
            for (i=2;i!=0;i++){
                is_prime=true;
                root = sqrt(i);
                for (unsigned int j:primes){
                    if (i%j==0){
                        is_prime = false;
                    }
                    if (j>root){
                        break;
                    }
                }
                if (is_prime){
                    primes.push_back(i);
                    log_primes.push_back(log(i));
                    cout<<(i&0xf);
                    cout<<endl;
                    if (((i&0xf)==0)&&(i*log2+2*log(i)>log_target)){
                        break;
                    }
                }
            }
        }
        int bin_search(unsigned int pair, int high){
            /* low should always be the index of a prime that for which the pairs log product is 
            less than or equal to the target.
            likewise high should be the index of a prime for which it is above it.
            we terminate when high-low = 1*/

            double log_pair = log(pair);
            int low = 0;
            int mid;
            while (high-low!=1){
                mid = (int) floor((high+low)/2);
                if (primes[mid]*log_pair+log_primes[mid]*pair>log_target){
                    high = mid;
                }
                else{
                    low = mid;
                }
            }
            return high;
        }
        unsigned long int calc_C(){
            unsigned long int count = 0;
            int ticker = 0;
            int height = primes.size()-1; //index of prime that for which the product is larger than target
            bool done = false;
            while (!done){
                //calculate new height
                height = bin_search(primes[ticker],height);
                if (height-ticker-1<=0){
                    done = true;
                }
                ticker++;
                count=count+height-ticker;
            }
            return count;
        }
};
int main(){
    prime_space m(800*log(800));
    cout<<m.calc_C();
    cout<<endl;
}