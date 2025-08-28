#include<iostream>
#include<vector>
using namespace std;

int leftRotate(vector<int>&nums){
    if(nums.size()<1){
        return 0;
    }

    int temp =nums[0];

    for(size_t i=1;i<nums.size();++i){
        nums[i-1]=nums[i];
    }

    nums[nums.size()-1]=temp;
}

void printVector(const vector<int>&nums){
    cout<<"rotate elements are[";
    for(size_t i=0;i<nums.size();++i){
    cout<<nums[i];
    if(i<nums.size()-1){
        cout<<",";
    }
}
    cout<<"]"<<endl;
}

int main(){
    vector<int> nums= {1,2,3,4,5,6,7,8,9,10};
    cout<<"Initial array:";
    printVector(nums);

    leftRotate(nums);

    cout<<"Rotated array:";
    printVector(nums);
    return 0;
}