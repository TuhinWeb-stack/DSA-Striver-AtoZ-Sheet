#include<iostream>


    void passByValue(int x){
        x = x+10;
        std :: cout << "Inside function: " << x << std:: endl;
    }

    void passByReference(int &x){
        x = x+10;
        std:: cout<<"Inside function: "<<x<<std::endl;
    }

    int main(){
    int a=5;

    passByValue(a);

    passByReference(a);
    return 0;
    }

