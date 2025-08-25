#include<iostream>
using namespace std;

void printArray(int arr[] , int n)
{
for(int i = 0 ; i < n ; i++)
cout<<arr[i]<<" ";
cout<<endl;

}

void printMin(int arr[] , int n)
{
    int min;
    for(int i = 0 ; i < n ; i++)
    {if(arr[i]< min)
        {
            min = arr[i];
        }
    }
    cout<<min<<endl;
}

void printMax(int arr[], int n)
{
    int max;
    for(int i = 0 ; i < n ; i++)
    {if(arr[i]> max)
        {  
            max = arr[i];
        }
    }
    cout<<max<<endl;
    }


int main()
{
    int arr[3];
    for(int j=0;j<3;j++)
    {
        cin>>arr[j];
    }
    printArray(arr,3);
    printMin(arr,3);
    printMax(arr,3);
    int size= sizeof(arr)/sizeof(int);
    cout<<"Size of arr"<<size;
    return 0;
}