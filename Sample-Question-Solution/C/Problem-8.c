#include <stdio.h> 

void swap(int *first, int *second) 
{ 
    int temp = *first; 
    *first = *second; 
    *second = temp; 
} 
  
// A function to implement bubble sort
void bubbleSort(int arr[], int n) 
{ 
   int i, j; 
   for (i = 0; i < n-1; i++)       
  
       // Last i elements are already in place    
       for (j = 0; j < n-i-1; j++)
       {
           if (arr[j] > arr[j+1]) 
           {
                swap(&arr[j], &arr[j+1]); 
           }
       }
}

void reverse(int arr[], int n) 
{ 
   int i = n/2, j = n -1; 
   while(i <= j)
   {
       swap(&arr[i], &arr[j]); 

       i++;
       j--;
   }       
} 
  
/* Function to print an array */
void printArray(int arr[], int size) 
{ 
    int i; 
    for (i=0; i < size; i++) 
        printf("%d ", arr[i]); 
    printf("\n"); 
} 
  
// Driver program to test above functions 
int main() 
{ 
    int arr[] = {64, 34, 25, 12, 42, 22, 11, 90}; 
    int n = sizeof(arr)/sizeof(arr[0]); 
    bubbleSort(arr, n);
    reverse(arr, n); 
    printf("Sorted array: \n"); 
    printArray(arr, n); 
    return 0; 
} 