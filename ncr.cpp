#include<iostream>
using namespace std;

    int factorial(int n){
    int fact=1;
    for(int i=1; i<=n; i++)
    {
        fact=fact*i;
    }
    return fact;

}

void ncr(int n , int r){
    int num= factorial(n);
    int denom= factorial(r)*factorial(n-r);
    int ans= num/denom;
    cout<<ans<<endl;
}

int main(){
    int n;
    int r;
    cin>>n>>r;
    ncr(n,r);
    
}