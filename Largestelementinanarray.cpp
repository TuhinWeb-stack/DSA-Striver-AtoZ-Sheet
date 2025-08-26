#include<iostream>
#include<vector>
using namespace std;

int largest(vector<int>&arr){
    int n= arr.size();
    if(n==0){
        return -1 ;
    }
    int largest = arr[0];
    for(int i=1;i<n;++i){
        if(arr[i]>largest){
            largest=arr[i];
        }
    }
    return largest;
}

int main(){
    int n;
    cout<<"Enter the number of elements:"<<endl;
    cin>>n ;
    vector<int> arr(n);
    cout<<"Enter the Elements:"<<endl;
    for(int i=0; i<n;i++){
        cin>>arr[i];
    }

    largest(arr);
    int max_val= largest(arr);
    cout<<"Largest element is:"<<endl;
    cout<<max_val<<endl;
    return 0;
}