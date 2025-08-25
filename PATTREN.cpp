#include<iostream>
#include<math.h>
using namespace std;
int main() {
    int n;
    cin>>n;

    int i = 0;
    float ans  = 0;

    int r = 1 +(~n);  //-n bhi likh skte hai
        

    while(r!=0){
        
       int bit = r&1; //checks lsb and stores it in ans
       ans = (bit * pow(10,i)) + ans;
       
       r = r>>1;
       i++;
    }
    cout<<ans;
    
}