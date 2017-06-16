# Vowel Search

## Problem

Given a stream, find the first vowel character v after a consonant, which is the predecessor of another vowel. Also, v
cannot be repeated in the stream. The end of the stream will be guaranteed by the `hasNext` method, which is going to
return `false` when the stream is over.

## Project Dependencies

- Maven 3.5.0
- Java 8
- JUnit 4

For more information about the dependencies required by this project, please, check the `pom.xml` file.

## Algorithm

1. Create an empty array of chars of length 3, named triplet
2. Create an empty set to keep all the vowels seen until a certain point in the stream
3. Create an empty queue to represent the list of unique vowel characters seen in order
4. For each character c read from the stream
    1.1 Add c to the triplet array (at the last position - 2)
    1.2 If the triplet has 3 chars, check if it is valid
        1.2.1 If it is valid (meaning that a vowel is followed by a consonant which is followed by another consonant)
            1.2.1.2 If c is unique (not in the vowel seen set), add c to the set, and add c to the queue
            1.2.1.3 If c is not unique, remove c from the queue
    1.3 Shift left the triplet by 1 position to make room for the next character in the stream
5. If the queue is empty, it means that there are no unique vowel characters in the strem
6. If the queue is NOT empty, return the first element of the queue, which is the first unique vowel seen in the stream