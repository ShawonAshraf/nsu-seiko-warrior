// source:  https://www.techstudy.org/cLanguage/Write-C-program-to-find-sum-of-array-elements-using-recursion
#include <stdio.h>  

int sum(int arr[], int start, int size)
{
    if(start >= size)
         return 0;

    return arr[start] + sum(arr, start+1, size); 
}

int main() 
{ 
    int arr[5] = {10, 20, 30, 40, 50};

    printf("Sum : %d\n", sum(arr, 0, 5));

    return 0; 
} 