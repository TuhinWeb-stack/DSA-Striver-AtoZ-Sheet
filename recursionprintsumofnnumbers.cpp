#include <iostream>
#include <math.h>
using namespace std;
int print( int n)
{
    if(n<=0)
    {
        return 0 ;
    }
    return n+print(n-1);
}

int main()
{
    int n;
    cout<<"Enter the number: ";
    cin>>n;
    int total=print(n);
    cout<<total<<endl;
    return 0;
}