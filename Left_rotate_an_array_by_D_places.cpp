#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

void reverse(vector<int>&nums , int start , int end){
    while (start<end)
    {
        swap(nums[start],nums[end]);
        start++;
        end--;
    }
    
}

void rotateByD(vector<int>&nums, int k){
    int n= nums.size();

    if(n==0 || k==0){
        return;
    }

    k=k%n;

    if(k==0){
        return;
    }

    reverse(nums , 0 , k-1);
    reverse(nums , k , n-1 );
    reverse(nums , 0 , n-1);
}

void printVector(const vector<int>&nums ){
    cout<<"roatated array is: [";
    for(size_t i=0;i<nums.size();++i){
        cout<<nums[i];
    
    if(i<nums.size()-1){
        cout<<",";
    }
}
    cout<<"]"<<endl;
}

int main(){
    vector<int> nums={1,2,3,4,5,6,7,8,9,10};
    int k =2;
    
    cout<<"Intial Array:   ";
    printVector(nums);

    rotateByD(nums , k);

    cout<<"Final Array:    ";
    printVector(nums);
    cout<<endl;
    return 0;
}