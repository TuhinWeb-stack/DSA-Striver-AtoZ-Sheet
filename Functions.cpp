#include<iostream>
using namespace std;

int power(int a, int b){
    int ans=1;
    for(int i=1;i<=b;i++){
        ans=ans*a;
    }
    
    cout<<"power of a is  "<<ans<<endl;
    
}
    
void evenodd(int n){
    if( n%2== 0){
        cout<<"even number"<<endl;
    }
    else{
            cout<<"odd number"<<endl;
        }
    }


    

int main()
{
    int a ,b;
    cin>>a>>b;
    power(a , b);
    
    int num;
    cin>>num;
    evenodd(num);
    
}
