#include<iostream>
#include<vector>
using namespace std;

void selectionSort(vector<int>&arr){
    int n= arr.size();
    for(int i=0;i<n-1;i++){
        int minIndex= i;
        for(int j=i+1;j<n;j++){
            if(arr[j]<arr[minIndex]){
                minIndex=j;
            }
        }
        swap(arr[minIndex],arr[i]);
    }
}

int main(){

    vector<int> arr={2,3,8,5,9,4,1};
    selectionSort(arr);

    for(int x : arr){
        cout<<x<<endl;
    }
    
}