#include<iostream>
#include<math.h>
using namespace std;



class solution{

    private:
    // A safer integer-based power function to avoid floating-point issues
    long long int_pow(int base, int exp) {
        long long result = 1;
        while (exp > 0) {
            result *= base;
            exp--;
        }
        return result;
    }

    public:
    bool isArmstrong (int n) {
        if(n<0){
            return false;
        }
        string s=to_string(n);
        int len = s.length();
        long long sum=0;
        int temp = n;
        while(temp>0){
            int digit = temp%10;
            sum +=int_pow(digit, len);
            temp /=10;
        }

        return sum== n;
    }
};

int main(){
    solution s;
    int n;
    cin>>n;
    int result = s.isArmstrong(n);
    if(result){
        cout<<"true"<<endl;
    }else{
        cout<<"false"<<endl;
    }
    // cout<<s.isArmstrong((n)? "true" : "false")<<endl;
    return 0;
}