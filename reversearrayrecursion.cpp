#include <iostream>
#include<vector>
#include<algorithm>
using namespace std;

void reverseArrayRecuesive(vector<int> &arr ,int start,int end){

    if(start>=end){
        return;
    }

    swap(arr[start],arr[end]);
    reverseArrayRecuesive(arr,start+1,end-1);

}

void printArray(vector<int> &arr){
    for(int element : arr){
        cout<<element<<" ";
    }
    cout<<endl;
}

int main() {

    int n;
    
    cout<<"Enter the size of the array:"<<endl;
    cin>>n;
    if(n<0){
        cout<<"Invalid Input"<<endl;
        return 0;
    }

    int eliment;
    vector<int> arr;
    cout<<"Enter the eliment of the array:"<<endl;

    for(int i=0;i<n;++i){
        cin>>eliment;
        arr.push_back(eliment);
    }

    cout<<"originarl array:"<<endl;
    printArray(arr);
    reverseArrayRecuesive(arr,0,n-1);
    cout<<"reversed array:"<<endl;
    printArray(arr);
    return 0;

}