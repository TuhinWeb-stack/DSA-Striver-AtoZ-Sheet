#include<iostream>
using namespace std;

int getLength(char str[]) {
    int count = 0;
    for( int i = 0; str[i] != '\0'; i++ ) {
        count++;
        }
        cout<<count<<endl;
    }


    
int main()
{
    char str[20];
    cin>>str;
    int size = sizeof(str)/sizeof(char);
    cout<<"Your Name is"<<endl;
    cout<<str<<endl;
    cout<<getLength(str)<<endl;
    
}