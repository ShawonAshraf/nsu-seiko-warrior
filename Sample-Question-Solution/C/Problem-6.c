#include <stdio.h>

void findDist(int array[], int size)
{
    int negIndex = -1, posIndex = -1, negDistance = -1, posDistance = -1;

    int i;
    for(i=0; i< size; i++)
    {
        if(array[i] >= 0)
        {
            if(posIndex >= 0)
            {
                if(posDistance < (i - posIndex))
                {
                    posDistance = i - posIndex;
                }
                posIndex = i;
            }
            else
            {
                posIndex = i;
            }
            
        }
        else
        {
            if(negIndex >= 0)
            {
                if(negDistance < (i - negIndex))
                {
                    negDistance = i - negIndex;
                }
                negIndex = i;
            }
            else
            {
                negIndex = i;
            }
        }
    }

    printf("Postitive: %d\nNegative: %d\n", posDistance, negDistance);

    if(posDistance > negDistance)
        printf("Maximum distance between same sign: %d\n", posDistance);
    else
        printf("Maximum distance between same sign: %d\n", negDistance);

}

int main()
{
    int size = 8;
    int array[size];

    int i;
    for(i=0; i< size; i++)
    {
        scanf("%d", &array[i]);
    }

    findDist(array, size);

    return 0;
}


