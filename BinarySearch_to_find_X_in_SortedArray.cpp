#include<iostream>
#include<vector>
using namespace std;

int binarySearch(vector<int>&nums , int key){
    int start =0;
    int end= nums.size()-1;
   

    while(start<=end){
        int mid= start+(end-start)/2;
        if(nums[mid]==key){
            return mid;
        }

        else if(nums[mid]<key){
            start=mid+1;
        }

        else{
            end=mid-1;
        }

    }
    return -1;
}

int main(){
    vector<int> nums={1,2,3,4,5,6,7,8,9};
    int k=4;
    int index=binarySearch(nums, k);
    cout<<"the index of 4 is"<<index<<endl;
    cout<<"Result is correct or not:  "<<(index==3 ? "true":"false")<<endl;
    return 0;
}