#include<iostream>
#include<vector>
using namespace std;

int isDuplicate(vector<int>& nums){
    if( nums.empty()){
        return 0;
    }

    int k=1;

    for(size_t i=1; i<nums.size(); ++i){
        if(nums[i]!=nums[i-1]){
            nums[k]=nums[i];
            k++;
        }
    }

    return k;
}

void printUnique( const vector<int>&nums , int uniqueElement){
    
    cout<<"first "<<uniqueElement<< "is [";
    for(size_t i=0;i<uniqueElement; ++i){
        cout<<nums[i];
        if(i<uniqueElement-1){
            cout<<",";
        }
    }
    cout<<"]"<<endl;
}

int main(){
    vector<int> nums={1,2,2,2,2,2,2,2,2,2,2,2,3,3,3,3,3,3,3,3,4,4,4,4,4,4,4,4,5,5,5,5,5,5,6,6,6,6,6,6,6,7,7,7,7,7,7,7,8,8,8,8,8,8,8,9,9,9,9,9,10};
    int uniqueElement=isDuplicate(nums);
    cout<<"Output"<<uniqueElement<<endl;
    printUnique(nums, uniqueElement);
    cout<<endl;
}