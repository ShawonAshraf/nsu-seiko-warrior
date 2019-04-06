#include <stdio.h>  

int factorial(int number)
{
    if(number == 0 || number == 1)
        return 1;
    else
        return number*factorial(number-1);
}

int main() 
{ 
    int number;

    scanf("%d", &number);

    printf("Factorial of %d: %d\n", number, factorial(number));

    return 0; 
} 