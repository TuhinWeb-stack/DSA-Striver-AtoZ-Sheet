#include <iostream>
#include <vector>
using namespace std;
int main(){
vector<int> v;
cout<< "capacity"<<v.capacity()<<endl;
v.push_back(1);
v.push_back(2);
v.push_back(3);
cout<<"front"<<v.front()<<endl;
cout<<"capacity"<<v.capacity()<<endl;
cout<<"befor pop"<<endl;
for(int i:v){
    cout<<i<<endl;
}
v.pop_back();
cout<<"after pop"<<endl;
for(int i:v){
    cout<<i<<endl;
}
}