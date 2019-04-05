#include <stdio.h>

void countVC(char str[])
{
    int vowel =0, consonant =0;

    int i;
    // continue to loop through the string received by parameter str, 
    // until null character is found at end of the string
    for(i=0; str[i] != '\0'; i++)
    {
        // vowels can be in upper or lower case
        if(str[i] == 'a' || str[i] == 'A' || str[i] == 'e' || str[i] == 'E' || str[i] == 'i' || str[i] == 'I'|| str[i] == 'o' || str[i] == 'O'|| str[i] == 'u' || str[i] == 'U')
            vowel++;
        else
            consonant++;
    }

    printf("Vowel: %d\nConsonant: %d\n", vowel, consonant);
}

int main()
{
    // let's just declare a string of length 10 for example
    // last index will be used by the null character
    char str[10];

    scanf("%s", str);

    countVC(str);

    return 0;
}


