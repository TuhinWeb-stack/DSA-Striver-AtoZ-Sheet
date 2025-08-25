#include <iostream>
#include<string>
using namespace std;

int countDigits(int n){
    if(n== 0)
    {
        return 1;
    }
    string str = to_string(n);
    return str.length();
}
int main()
{
    int n;
    cin>>n;

    cout<<countDigits(n)<<endl;
    return 0;
}


        