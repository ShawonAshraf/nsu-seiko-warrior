#include <stdio.h>

// this solution will NOT work if there is any zero in the decimal number
// wrong number - 123054.505 or 123204.343 or 123123.406
void countDigit(double number)
{
    int beforeDecimal = 0, afterDecimal = 0;

    // if we cast the double number into an integer then, we will get the integer portion
    // 12314 = (int)12314.343
    int copyNumber = number;

    // keep checking if the last digit is 0,
    // if zero then the loop will not execute
    while(copyNumber % 10)
    {
        beforeDecimal++;

        // if we divide a integer with 10
        // we can remove the last digit
        // 123 = 1231 / 10 
        copyNumber /= 10;
    }
    
    
    while(1)
    {
        // if we multiply a decimal number with 10
        // then the decimal point will move 1 place to the right
        // 1231.45 * 10 = 12314.5
        number *= 10;

        int secondCopy = number;
        
        // now check if the last digit is 0
        // because, if we keep multiplying with 10,
        // at one point the number will become like 1231450
        // then we are done
        if(secondCopy % 10 == 0){
            break;
        }
        
        afterDecimal++;
    }

    printf("Before Decimal: %d\n", beforeDecimal);
    printf("After Decimal: %d\n", afterDecimal);
}

int main()
{
    double number;
    
    scanf("%lf", &number);

    countDigit(number);

    return 0;
}


