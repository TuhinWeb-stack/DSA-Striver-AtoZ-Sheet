#include<iostream>
using namespace std;

int findSqrt(int n){
    if(n<0){
        return -1;
    }
    if(n==0 || n==1){
        return n;
    }
    int start=0;
    int end=n;
    int ans =1;

    while(start<=end){
        long long mid=start+(end-start)/2;
        long long square=mid*mid;
        if(square==n){
            return mid;
        }

        else if(square<n){
            ans=mid;
            start=mid+1;
        }
        else{
            end=mid-1;
        }
    }
    return ans;
}

int main(){
    int n;
    int index;
    cout<<"Enter the element:  ";
    cin>>n;
    index=findSqrt(n);
    cout<<"The Square root of  is:"<<index<<endl;
    return 0;

}