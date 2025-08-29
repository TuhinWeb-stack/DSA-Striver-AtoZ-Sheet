#include<iostream>
#include<vector>
using namespace std;

int find_first_one(const vector<int>& row_vec){
    int start=0;
    int end =row_vec.size()-1;
    int first_one_index= -1;
    int key = 1;

    while(start<=end){
        int mid=start+(end-start)/2;
        if(row_vec[mid]==key){
            first_one_index= mid;
            end=mid-1;
        }
        else{
            start=mid+1;
        }
    }
    return first_one_index;
}

int find_row_with_max_ones (const vector<vector<int>>&mat){
    int mat_rows=mat.size();
    int mat_cols=mat[0].size();
    int max_ones_count=-1;
    int result_ones_index=-1;

    for(int i=0; i<mat_rows; ++i){
        int find_one_index =find_first_one(mat[i]);
        if(find_one_index!=-1){
            int current_ones_count =mat_cols- find_one_index;
        
        if(max_ones_count<current_ones_count){
            max_ones_count=current_ones_count;
            result_ones_index=i;
        }

        }
    }
    return result_ones_index;
}

int main(){
    vector<vector<int>> mat ={
        {1,1,1},
        {0,0,1},
        {0,0,0}
    };
    cout<<"index of the row with maximum number of ones is:  "<<find_row_with_max_ones(mat)<<endl;
    return 0;
}