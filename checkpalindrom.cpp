#include<iostream>
using namespace std;

bool isPalindrom(int n){
    if(n,0){
        return false;
    }

    int original_num =n;
    int reversed_num=0;

    while(n!=0){
        int digit =n%10;
        reversed_num=reversed_num*10 +digit;
        n=n/10;
    }
    return  original_num== reversed_num;

}

int main(){
    int n;
    cin>>n;
    cout<<"check palindrom   "<<(isPalindrom(n)? "true": "false")<<endl;
    return 0;
}

