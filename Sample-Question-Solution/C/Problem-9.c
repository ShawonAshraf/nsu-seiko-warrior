// source: https://www.geeksforgeeks.org/print-all-distinct-characters-of-a-string-in-order-3-methods/
#include <stdio.h>  
#define NO_OF_CHARS 256 
  
/* Print duplicates present in the passed string */
void printDistinct(char *str) 
{ 
    // Create an array of size 256 and count of 
    // every character in it 
    int count[NO_OF_CHARS]; 
  
    /* Count array with frequency of characters */
    int i; 
    for (i = 0; str[i]; i++)
    {
        if(str[i] != ' ')
        {
            count[str[i]]++; 
        } 
    }       
    int n = i; 
  
    // Print characters having count 1
    for (i = 0; i < n; i++)
    { 
        if (count[str[i]] == 1) 
        {
            printf("%c", str[i]);          
        }
    }

    printf("\n");
} 
  
/* Driver program*/
int main() 
{ 
    char str[NO_OF_CHARS];

    scanf("%s", str);

    printDistinct(str);

    return 0; 
} 