#include<iostream>
#include<vector>
#include<climits>
using namespace std;

int secondLargest(const vector<int>& nums){
    if(nums.size()<2){
        return -1;
    }

    int largest = INT_MIN;
    int secondlargest = INT_MIN;

    for(int num : nums){
        if(num>largest){
            secondlargest= largest;
            largest=num;

        }
        else if (num>secondlargest && num!= largest)
        {
            secondlargest=num;
        }
        
    }
    if(secondlargest== INT_MIN){
        return -1;
    }
    return secondlargest;
}

int main(){
    vector<int> nums= {1,2,3,4,5,6,7,8,8,8,8,8};
    cout<<"the second largest is: :"<<secondLargest(nums)<<endl;
    return 0;
}