#include<iostream>
using namespace std;

int reverseNumber(int n){
    int reversednum =0;
    while(n!=0){
        int digit = n%10;
        reversednum = reversednum * 10 + digit;
        n/=10;
    }
    
    return reversednum;
}

int main()
{
    int n;
     cin>>n;
    int reversed = reverseNumber(n);
   
    cout<<reversed<<endl;
    return 0;
}