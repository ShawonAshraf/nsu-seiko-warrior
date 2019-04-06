#include <stdio.h>

void findNum(int array[], int size)
{
    int i, max = -1;
    for(i=0; i< size; i++)
    {
        if(array[i] < 0)
        {
            array[i] *= -1;
        }

        if (array[i] > max) {
            max = array[i];
        }
    }
    
    printf("Max: %d\n", max);
}

int main()
{
    int size = 10;
    int array[size];

    int i;
    for(i=0; i< size; i++)
    {
        scanf("%d", &array[i]);
    }

    findNum(array, size);

    return 0;
}


