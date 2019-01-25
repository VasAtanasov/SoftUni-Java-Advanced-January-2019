# Lab: Linear Data Structures

This document defines the exercises for "Java Advanced" course @ Software University. Please submit your solutions (source code) of all below described problems in Judge.

## I. Multidimensional Arrays

### 1. Compare Matrices

Write a program that reads two integer matrices (2D arrays) from the console and compares them element by element. For better code reusability, you could do the comparison in a method, which returns true if they are equal and false if not.
Each matrix definition on the console will contain a line with a positive integer number R – the number of rows in the matrix and C – the number of columns – followed by R lines containing the C numbers, separated by spaces (each line will have an equal amount of numbers.
The matrices will have at most 10 rows and at most 10 columns.
Print equal if the matrices match, and not equal if they don’t match.

### Examples

|Input|	Output|
|:-----|:-------|
|2 3<br>1 2 3<br>2 1 3<br>2 3<br>1 2 3<br>2 1 3|equal|
|2 3<br>1 2 3<br>4 5 6<br>2 2<br>1 3<br>4 5|not equal|

Read matrix:

![](../../resources/L05MultidimensionalArrays/image1.png)

Compare method:

![](../../resources/L05MultidimensionalArrays/image2.png)

<p><b>Solution: <a href="./Ex01CompareMatrices.java">Ex01CompareMatrices.java</a></b></p>

 
### 2. Positions Of

Write a program that reads a matrix of integers from the console, then a number and prints all the positions at which that number appears in the matrix.
The matrix definition on the console will contain a line with two positive integer numbers R and C – the number of rows and columns in the matrix – followed by R lines, each containing C numbers (separated by spaces), representing each row of the matrix.
The number you will need to find the positions of will be entered on a single line, after the matrix.
You should print each position on a single line – first print the row, then the column at which the number appears.
If the number does not appear in the matrix, print not found

### Examples

|Input|	Output|
|:-----|:-------|
|2 3<br>1 2 3<br>4 2 2<br>2|0 1<br>1 1<br>1 2<br>2 3|
|1 -2 -3<br>4 -5 6<br>5|not found|

### Hint:

1. Read matrix – look Problem 01
2. Find position:

![](../../resources/L05MultidimensionalArrays/image3.png)

<p><b>Solution: <a href="./Ex02PositionOf.java">Ex02PositionOf.java</a></b></p>

### 3. Intersection of Two Matrices

Write a program that reads two char matrices (A[][] and B[][]) of the same order M * N and prints third matrix C[][] which is filled with the intersecting elements of A and B, otherwise set the element to '*'. On the first two lines you receive M and N, then on 2 * M lines N characters – the matrices elements. 
The matrix elements may be any ASCII char except '*'.

### Examples

|Input|	Output|
|:-----|:-------|
|3<br>4<br>a b c d<br>a b c d<br>a b c d<br>k b c k<br>a b g d<br>a k c d|* b c *<br>a b * d<br>a * c d|

<p><b>Solution: <a href="./Ex03IntersectionOfTwoMatrices.java">Ex03IntersectionOfTwoMatrices.java</a></b></p>


### 4. Sum Matrix Elements

Write a program that reads a matrix from the console and prints:
- The count of rows
- The count of columns
- The sum of all matrix’s elements
On the first line you will get the dimensions of the matrix in format {rows, columns}. On the next lines you will get the elements for each row separated with a coma.

### Examples

|Input|Output|
|:-----|:-------|
|3, 6<br>7, 1, 3, 3, 2, 1<br>1, 3, 9, 8, 5, 6<br>4, 6, 7, 9, 1, 0|3<br>6<br>76|

### Hint:

![](../../resources/L05MultidimensionalArrays/image4.png)

<p><b>Solution: <a href="./Ex04SumMatrixElements.java">Ex04SumMatrixElements.java</a></b></p>
 
### 5. Maximum Sum of 2x2 Submatrix

Write a program that reads a matrix from the console. Then find the biggest sum of a 2x2 submatrix. Print the submatrix and its sum.
On the first line you will get the dimensions of the matrix in format {rows, columns}. On the next lines you will get the elements for each row separated with a coma.

### Examples

|Input|Output|
|:-----|:-------|
|3, 6<br>7, 1, 3, 3, 2, 1<br>1, 3, 9, 8, 5, 6<br>4, 6, 7, 9, 1, 0|9 8<br>7 9<br>33|
|2, 4<br>10, 11, 12, 13<br>14, 15, 16, 17|12 13<br>16 17<br>58|

<p><b>Solution: <a href="./Ex05MaximumSumOf2x2SubMatrix.java">Ex05MaximumSumOf2x2SubMatrix.java</a></b></p>


### 6.	Print Diagonals of Square Matrix

Write a program that reads a matrix from the console. Then print the diagonals. The matrix will always be square. On the first line you read a single integer N the matrix size. Then on each line N elements. The first diagonal should always start with the element at the first row and col, the second diagonal should start with the element at the last row and first col.

### Examples

|Input|Output|
|:-----|:-------|
|3<br>1 2 3<br>1 2 3<br>1 2 3|1 2 3<br>1 2 3|
|4<br>1 2 3 2<br>1 1 2 4<br>1 2 1 4<br>2 2 3 1|1 1 1 1<br>2 2 2 2|

<p><b>Solution: <a href="./Ex06PrintDiagonals.java">Ex06PrintDiagonals.java</a></b></p>

### 7.** Find The Real Queen

Write a program that reads (8 x 8) matrix of characters from the console. The matrix represents a chess board with figures on it. The figures can be - queens as char 'q' or any other ASCII symbol. There will be more than one queen but only one queen will have valid position, which is not attacked from any other queen and does not attack any other queen. In other word in the way of the valid queen there are no other queens, but there may be any other ASCII symbol. Your task is to read the chessboard and find the position of the valid queen. According to chess rules the queen can attack all the cells in horizontal vertical and both diagonals which cross the queen position.

### Examples

|Input|Output|
|:-----|:-------|
|p a p a p a p a<br>p a p a p a p a<br>p a q a p a q a<br>p a p a p a p a<br>p a p q p a p a<br>p a p a p a p a<br>p a q a p a q a<br>p a p a p a p a|4 3|
|1 q q q 1 q q q<br>q 1 q q 1 q q 1<br>q q 1 q 1 q 1 q<br>q q q 1 1 1 q q<br>1 1 1 1 q 1 1 1<br>q q q 1 1 1 q q<br>q q 1 q 1 q 1 q<br>q 1 q q 1 q q 1|4 4|

<p><b>Solution: <a href="./Ex07FindTheRealQueen.java">Ex07FindTheRealQueen.java</a></b></p>

### 8. Wrong Measurements

You will be given the rows of a matrix. Then the matrix itself. Inside this matrix there are mistaken values which need to be replaced you will receive the wrong value at the last line. Those values should be replaced with the sum of the nearest elements in the four directions up, down, left and right, but only if they are valid values. At the end you have to print the fixed measurements. 

### Examples

|Input|Output|
|:-----|:-------|
|3<br>1 2 4<br>4 6 7<br>8 9 4<br>1 0|1 2 9<br>15 6 7<br>8 9 16|
|3<br>1 2 4 4<br>4 6 4 3<br>8 9 4 2<br>1 0|1 2 2 3<br>15 6 6 3<br>8 9 9 2|

<p><b>Solution: <a href="./Ex08WrongMeasurements.java">Ex08WrongMeasurements.java</a></b></p>

<p><b>Document with tasks description: <a href="../../resources/L05MultidimensionalArrays/02. Java-Advanced-MultidimensionalArrays-Lab.docx">02. Java-Advanced-MultidimensionalArrays-Lab.docx</a></b></p>