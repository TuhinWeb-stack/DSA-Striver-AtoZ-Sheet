#include<iostream>
#include<vector>
using namespace std;

bool isSorted(vector<int>& nums){
    if(nums.size()<=1){
        return true;
    }

    for(size_t i=1; i<nums.size(); ++i){
        if(nums[i]<nums[i-1]){
            return false;
        }
    }

    return true;
}

int main(){
    vector<int> nums={1,2,3,4,5,6,7,8,9,10};
    cout<<boolalpha;
    cout<<"is sorted or not:  "<<isSorted(nums)<<endl;
    
}