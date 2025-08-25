#include <iostream>
using namespace std;

long long factorial(int n){
    if(n==0){
        return 1;
    }
    return n*factorial(n-1);
}

int main() {
    int n;
    cout<<"Enter the number"<<endl;
    cin>>n;
    if(n<0){
        cout<<"Factorial of negative number is not possible"<<endl;
    }else{
        long long fact=factorial(n);
        cout<<"Factorial of "<<n<<" is "<<fact<<endl;
    }
    return 0;
}