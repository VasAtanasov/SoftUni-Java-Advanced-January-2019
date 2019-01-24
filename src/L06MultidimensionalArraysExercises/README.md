# **Multidimensional Arrays - Exercises**

This document defines the exercises for "Java Advanced" course @ Software University. Please submit your solutions (source code) of all below described problems in Judge.

## **Matrices:**

### **1. Fill the Matrix**
Filling a matrix in the regular way (top to bottom and left to right) is boring. Write two methods that fill a matrix of size N x N in two different patterns.

### **Examples**

<img src="data:image/png;base64,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86Pz58/Pnj37b3/72+OPPz5ixIjjx49bB1zHTa1Crwt0GzJkCP1mx44d33jjDdd0M1cp0/lRqmJjzUzmPfbYY57yI9/3s7dv375p06atW7cym508edKFT7jdjzotzORcHa+pX78+MzlLFetACkePHqWckIi6Qi5Esw64jmtaBVcXly5dopnauXMnt8fqjIXe3Xff3bBhwzfffJMVH6ZmjXMYc5UyY3/ky7lz5zzoR76f93P1okWLVq5c+b777hs3bpy9gnOuS8qoZ+3LxYsX9+7dix8VKFCgTJky9ErWgRTWrl1bu3btPHny3HXXXW+99daJEyesA66TUVqZ1AUZgowsexmQP3/+YsWKFSlSJGfOnM2bN3ftnSPBXCX1o0C4H/VVfx5S4Fs6BSqTvj3iP+//448/zpw5gxQ1a9YsX748Hr1s2bINGzYwq2NGeFClSpWwbFKCqV79yMSP5GfZqlSp8tBDD3322WenTp1yOpFszFVSPwqE+1Gn/X0RVmqsVqZNm4ZDxcXFPf7445988sm3335rneAAGfWsU0E5HTlyZOLEiY888kiFChWoKKZ3eqWqVas2adKkR48euHanTp2GDBnC8s06x3UySivDurDXa+vXrxcr//TTTwcPHlyvXr3WrVuvWrXKnd+5MVdJ/SgQLkcdIDO++eabzp07I0L9+vUHDBjg6M8lZ9SzTsuff/5JpFOnTm3UqFF0dDR+hCPXqVPn/vvvR4ShQ4f27duXNezJkyetE1wno7QKui4woJkzZ2LuefPmnTx58vnz5zPVO5LqR4HIqKjTwuKFNUuLFi1q165Ni3TgwAHrgANknqgxaOqH2Hfs2JGQkMAkT9v49ddfr169muaoa9euY8eOZecPP/xgneA6GaVVKHWxbds2em1WwePHjz98+DAKWwccw1ylzO5H33///bx585544gka9bvvvnvfvn3WAVfIqKjTcujQoX79+rFOadq0af/+/b3QHwXoFrkxWqRWrVotWLCAyvTI74v4Ekpd4Oy33XZbxYoVaTxpLX///XfrgGOYq5Tp/ChVFpJqixcvlp9Dvffee1O9U+D00te1qIUA4axZs6ZKlSp58uTp3r37p59+6uhPJLsctT+uqsalS5cI/8knn6RPfPDBB1P93Lb7uKZVuOrixIkTo0aNuummm2JiYpYvX27tdRhzlTJjf3Tx4kXW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" alt="">

|Input|	Output|
|:-----|:-------|
|3, A|1 4 7<br>2 5 8<br>3 6 9|
|3, B|1 6 7<br>2 5 8<br>3 4 9|

### **Hints**

- Make a different method for each pattern
- Make a method for printing the matrix

### **2. Matrix of Palindromes**

Write a program to generate the following matrix of palindromes of 3 letters with r rows and c columns like the one in the examples below.
- Rows define the first and the last letter: row 0  ‘a’, row 1  ‘b’, row 2  ‘c’, …
- Columns + rows define the middle letter: 
  - column 0, row 0  ‘a’, column 1, row 0  ‘b’, column 2, row 0  ‘c’, …
  - column 0, row 1  ‘b’, column 1, row 1  ‘c’, column 2, row 1  ‘d’, …

### **Input**

- The numbers r and c stay at the first line at the input.
- r and c are integers in the range [1…26].
- r + c ≤ 27

### **Examples**

Input|	Output|
|:-----|:-------|
|4 6|aaa aba aca ada aea afa<br>bbb bcb bdb beb bfb bgb<br>ccc cdc cec cfc cgc chc<br>ddd ded dfd dgd dhd did|
|3 2|aaa aba<br>bbb bcb<br>ccc cdc|

### **Hints**

- Use two nested loops to generate the matrix.
- Print the matrix row by row in a loop.
- Don’t forget to pack everything in methods.

### **3. Diagonal Difference**

Write a program that finds the difference between the sums of the square matrix diagonals (absolute value).
 
### **Input**

- The first line holds a number n – the size of matrix.
- The next n lines hold the values for every row – n numbers separated by a space.

### **Examples**

Input|Output|Comments|
|:-----|:-------|:-------|
|3<br>11 2 4<br>4 5 6<br>10 8 -12|15|Primary diagonal: sum = 11 + 5 + (-12) = 4<br>Secondary diagonal: sum = 4 + 5 + 10 = 19<br>Difference: Abs(4 - 19) = 15|

### **Hints**

- Use a single loop i = [1 … n] to sum the diagonals.
- The primary diagonal holds all cells {row, col} where row == col == i.
- The secondary diagonal holds all cells {row, col} where row == i and col == n-1-i.

### **4. Maximal Sum**

Write a program that reads a rectangular integer matrix of size N x M and finds in it the square 3 x 3 that has maximal sum of its elements. 

### **Input**

- On the first line, you will receive the rows N and columns M. 
- On the next N lines you will receive each row with its elements.

Print the elements of the 3 x 3 square as a matrix, along with their sum. See the format of the output below:

### **Examples**

Input|Output|
|:-----|:-------|
|4 5<br>1 5 5 2 4<br>2 1 4 14 3<br>3 7 11 2 8<br>4 8 12 16 4|Sum = 75<br>1 4 14<br>7 11 2<br>8 12 16|	 

### **5. Matrix shuffling**

Write a program which reads a string matrix from the console and performs certain operations with its elements. User input is provided in a similar way like in the problems above – first you read the dimensions and then the data. 
Your program should then receive commands in format: "swap row1 col1 row2c col2" where row1, row2, col1, col2 are coordinates in the matrix. In order for a command to be valid, it should start with the "swap" keyword along with four valid coordinates (no more, no less). You should swap the values at the given coordinates (cell [row1, col1] with cell [row2, col2]) and print the matrix at each step (thus you'll be able to check if the operation was performed correctly). 
If the command is not valid (doesn't contain the keyword "swap", has fewer or more coordinates entered or the given coordinates do not exist), print "Invalid input!" and move on to the next command. Your program should finish when the string "END" is entered.

### **Examples**

Input|Output|
|:-----|:-------|
|2 3<br>1 2 3<br>4 5 6<br>swap 0 0 1 1<br>swap 10 9 8 7<br>swap 0 1 1 0<br>END|5 2 3<br>4 1 6<br>Invalid input!<br>5 4 3<br>2 1 6|
|1 2<br>Hello World<br>0 0 0 1<br>swap 0 0 0 1<br>swap 0 1 0 0<br>END|Invalid input!<br>World Hello<br>Hello World|

### **Hints**

- Think about Exception Handling 

6.	 String Matrix Rotation
You are given a sequence of text lines. Assume these text lines form a matrix of characters (pad the missing positions with spaces to build a rectangular matrix). Write a program to rotate the matrix by 90, 180, 270, 360, … degrees. Print the result at the console as sequence of strings after receiving the “END” command.

Examples
Input	Rotate(90)	Rotate(180)	Rotate(270)
hello
softuni
exam
END	 	 	 
 			
Input
The input is read from the console:
•	The first line holds a command in format "Rotate(X)" where X are the degrees of the requested rotation.
•	The next lines contain the lines of the matrix for rotation.
•	The input ends with the command "END".
The input data will always be valid and in the format described. There is no need to check it explicitly.
Output
Print at the console the rotated matrix as a sequence of text lines.
Constraints
•	The rotation degrees is positive integer in the range [0…90000], where degrees is multiple of 90.
•	The number of matrix lines is in the range [1…1 000].
•	The matrix lines are strings of length 1 … 1 000.
•	Allowed working time: 0.2 seconds. Allowed memory: 16 MB.
Examples
Input	Output		Input	Output		Input	Output
Rotate(90)
hello
softuni
exam
END	esh
xoe
afl
mtl
 uo
 n 
 i 		Rotate(180)
hello
softuni
exam
END	   maxe
inutfos
  olleh		Rotate(270)
hello
softuni
exam
END	 i 
 n 
ou 
ltm
lfa
eox
hse

Input	Output		Input	Output		Input	Output
Rotate(720)
js
exam
END	js
exam
		Rotate(810)
js
exam
END	ej
xs
a
m		Rotate(0)
js
exam
END	js
exam

7.	Crossfire 
You will receive two integers which represent the dimensions of a matrix. Then, you must fill the matrix with increasing integers starting from 1, and continuing on every row, like this:
first row: 1, 2, 3, …, n
second row: n + 1, n + 2, n + 3, …, n + n
third row: 2 * n + 1, 2 * n + 2, …, 2 * n + n
You will also receive several commands in the form of 3 integers separated by a space. Those 3 integers will represent a row in the matrix, a column and a radius. You must then destroy the cells which correspond to those arguments cross-like.
Destroying a cell means that, that cell becomes completely nonexistent in the matrix. Destroying cells cross-like means that you form a cross figure with center point - equal to the cell with coordinates – the given row and column, and lines with length equal to the given radius. See the examples for more info. 
The input ends when you receive the command “Nuke it from orbit”. When that happens, you must print what has remained from the initial matrix.
Input
•	On the first line you will receive the dimensions of the matrix. You must then fill the matrix according to those dimensions
•	On the next several lines you will begin receiving 3 integers separated by a single space, which represent the row, col and radius. You must then destroy cells according to those coordinates
•	When you receive the command “Nuke it from orbit” the input ends
Output
•	The output is simple. You must print what is left from the matrix
•	Every row must be printed on a new line and every column of a row - separated by a space
Constraints
•	The dimensions of the matrix will be integers in the range [2, 100]
•	The given rows and columns will be valid integers in the range [-231 + 1, 231 - 1]
•	 The radius will be in range [0, 231 - 1]
•	Allowed time/memory: 250ms/16MB
Examples
Input	Output	Comment
5 5
3 3 2
4 3 2
Nuke it from orbit	1 2 3 4 5
6 7 8 10
11 12 13
16
21	Initial matrix:
1  2  3  4  5
6  7  8  9  10
11 12 13 14 15
16 17 18 19 20
21 22 23 24 25
Result from first destruction:
1  2  3  4  5
6  7  8  10
11 12 13 15
16           
21 22 23 25
Result from second destruction:
1  2  3  4  5
6  7  8  10
11 12 13
16
21

5 5
4 4 4
Nuke it from orbit	1 2 3 4
6 7 8 9
11 12 13 14
16	7 18 19	


8.	The Heigan Dance
At last, level 80. And what do level eighties do? Go raiding. This is where you are now – trying not to be wiped by the famous dance boss, Heigan the Unclean. The fight is pretty straightforward - dance around the Plague Clouds and Eruptions, and you’ll be just fine.
Heigan’s chamber is a 15-by-15 two-dimensional array. The player always starts at the exact center. For each turn, Heigan uses a spell that hits a certain cell and the neighboring rows/columns. For example, if he hits (1,1), he also hits (0,0, 0,1, 0,2, 1,0 … 2,2). If the player’s current position is within the area of damage, the player tries to move. First, he tries to move up, if there’s damage/wall, he tries to move right, then down, then left. If he cannot move in any direction, because the cell is damaged or there is a wall, the player stays in place and takes the damage.
Plague cloud does 3500 damage when it hits, and 3500 damage the next turn. Then it expires. Eruption does 6000 damage when it hits. If a spell hits a player that also has an active Plague Cloud from the previous turn, the cloud damage is applied first. Both Heigan and the player may die in the same turn. If Heigan is dead, the spell he would have casted is ignored.
The player always starts at 18500 hit points; Heigan starts at 3,000,000 hit points. Each turn, the player does damage to Heigan. The fight is over either when the player is killed, or Heigan is defeated.
Input
•	On the first line you receive a floating-point number D – the damage done to Heigan each turn
•	On the next several lines – you receive input in format {spell} {row} {col} – {spell} is either Cloud or Eruption
Output
•	    On the first line  
o	If Heigan is defeated: “Heigan: Defeated!”
o	Else: “Heigan: {remaining}”, where remaining is rounded to two digits after the decimal separator
•	    On the second line:
o	If the player is killed: “Player: Killed by {spell}”
o	Else “Player: {remaining}”
•	    On the third line: “Final position: {row,  col}” -> the last coordinates of the player
Constraints
•	D is a floating-point number in range [0 … 500000]
•	A damaging spell will always affect at least one cell
•	Allowed memory: 16 MB
•	Allowed working time: 0.25s
Examples
Input	Output
10000
Cloud 7 7
Eruption 6 7
Eruption 8 7
Eruption 8 7	Heigan: 2960000.00
Player: Killed by Eruption
Final position: 8, 7




Input	Output
500000
Cloud 7 6
Eruption 7 8
Eruption 7 7
Cloud 7 8
Eruption 7 9
Eruption 6 14
Eruption 7 11	Heigan: Defeated!
Player: 12500
Final position: 7, 11






Input	Output
12500.66
Cloud 7 7
Cloud 7 7
Cloud 7 7
Cloud 7 7	Heigan: 2949997.36
Player: Killed by Plague Cloud
Final position: 7, 7




9.	*Parking System
The parking lot in front of SoftUni is one of the busiest in the country, and it’s a common cause for conflicts between the doorkeeper Bai Tzetzo and the students. The SoftUni team wants to proactively resolve all conflicts, so an automated parking system should be implemented. They are organizing a competition – Parkoniada – and the author of the best parking system will win a romantic dinner with RoYaL. That’s exactly what you’ve been dreaming of, so you decide to join in.
The parking lot is a rectangular matrix where the first column is always free and all other cells are parking spots. A car can enter from any cell of the first column and then decides to go to a specific spot. If that spot is not free, the car searches for the closest free spot on the same row. If all the cells on that specific row are used, the car cannot park and leaves. If two free cells are located at the same distance from the initial parking spot, the cell which is closer to the entrance is preferred. A car can pass through a used parking spot.
Your task is to calculate the distance travelled by each car to its parking spot.
Example: A car enters the parking at row 1. It wants to go to cell 2, 2 so it moves through exactly four cells to reach its parking spot.


Input
•	On the first line of input, you are given the integers R and C, defining the dimensions of the parking lot
•	On the next several lines, you are given the integers Z, X, Y where Z is the entry row and X, Y are the coordinates of the desired parking spot
•	The input stops with the command ‘stop’. All integers are separated by a single space
Output
•	For each car, print the distance travelled to the desired spot or the first free spot
•	If a car cannot park on its desired row, print the message ‘Row {row number} full’
Constraints
•	2 ≤ R,C ≤ 10000
•	Z, X, Y are inside the dimensions of the matrix. Y is never on the first column
•	There are no more than 1000 input lines
•	Allowed time/space: 0.1s (C#) /16MB
Examples
Input	Output
4 4
1 2 2
2 2 2
2 2 2
3 2 2
stop	4
2
4
Row 2 full

10.	*Radioactive Mutant Vampire Bunnies
Browsing through GitHub, you come across an old JS Basics teamwork game. It is about very nasty bunnies that multiply extremely fast. There’s also a player that has to escape from their lair. You really like the game so you decide to port it to C# because that’s your language of choice. The last thing that is left is the algorithm that decides if the player will escape the lair or not.
First, you will receive a line holding integers N and M, which represent the rows and columns in the lair. Then you receive N strings that can only consist of “.”, “B”, “P”. The bunnies are marked with “B”, the player is marked with “P”, and everything else is free space, marked with a dot “.”. They represent the initial state of the lair. There will be only one player. Then you will receive a string with commands such as LLRRUUDD – where each letter represents the next move of the player (Left, Right, Up, Down).
After each step of the player, each of the bunnies spread to the up, down, left and right (neighboring cells marked as “.” changes their value to B). If the player moves to a bunny cell or a bunny reaches the player, the player has died. If the player goes out of the lair without encountering a bunny, the player has won.
When the player dies or wins, the game ends. All the activities for this turn continue (e.g. all the bunnies spread normally), but there are no more turns. There will be no stalemates where the moves of the player end before he dies or escapes.
Finally, print the final state of the lair with every row on a separate line. On the last line, print either “dead: {row} {col}” or “won: {row} {col}”. Row and col are the coordinates of the cell where the player has died or the last cell he has been in before escaping the lair.
Input
•	On the first line of input, the numbers N and M are received – the number of rows and columns in the lair
•	On the next N lines, each row is received in the form of a string. The string will contain only “.”, “B”, “P”. All strings will be the same length. There will be only one “P” for all the input
•	On the last line, the directions are received in the form of a string, containing “R”, “L”, “U”, “D”
Output
•	On the first N lines, print the final state of the bunny lair
•	On the last line, print the outcome – “won:” or “dead:” + {row} {col}
Constraints
•	The dimensions of the lair are in range [3…20]
•	The directions string length is in range [1…20]
Examples
Input	Output
5 8
.......B
...B....
....B..B
........
..P.....
ULLL	BBBBBBBB
BBBBBBBB
BBBBBBBB
.BBBBBBB
..BBBBBB
won: 3 0

4 5
.....
.....
.B...
...P.
LLLLLLLL	.B...
BBB..
BBBB.
BBB..
dead: 3 1

11.	 Reverse Matrix Diagonals
You are given a matrix (2D array) of integers. You have to print the matrix diagonal but in reversed order. Print each diagonal on new line.

Input
On the first line, single integer the number R of rows in the matrix. On each of the next R lines, C numbers separated by single spaces. Note that R and C may have different values. 
Output
The output should consist of R lines, each consisting of exactly C characters, separated by spaces, representing the matrix diagonals reversed.
Constraints
All the integers will be in the range [1….1000]
Examples
Example Input	Expected Output
3 4
21 20 18 15
19 17 14 12
16 13 11 10	10
11 12
13 14 15
16 17 18
19 20
21
1 3
3 2 1	1
2
3
3 3
18 17 15
16 14 12
13 11 10	10
11 12
13 14 15
16 17
18

12.*** The Matrix
You are given a matrix (2D array) of lowercase alphanumeric characters (a-z, 0-9), a starting position – defined by a start row startRow and a start column startCol – and a filling symbol fillChar. Let’s call the symbol originally at startRow and startCol the startChar. Write a program, which, starting from the symbol at startRow and startCol, changes to fillChar every symbol in the matrix which:
•	is equal to startChar AND
•	can be reached from startChar by going up (row – 1), down (row + 1), left (col – 1) and right (col + 1) and “stepping” ONLY on symbols equal startChar 
So, you basically start from startRow and startCol and can move either by changing the row OR column (not both at once, i.e. you can’t go diagonally) by 1, and can only go to positions which have the startChar written on them. Once you find all those positions, you change them to fillChar. 
In other words, you need to implement something like the Fill tool in MS Paint, but for a 2D char array instead of a bitmap.
Input
On the first line, two integers will be entered – the number R of rows and number C of columns.
On each of the next R lines, C characters separated by single spaces will be entered – the symbols of the Rth row of the matrix, starting from the 0th column and ending at the C-1 column.
On the next line, a single character – the fillChar – will be entered.
On the last line, two integers – startRow and startCol – separated by a single space, will be entered.
Output
The output should consist of R lines, each consisting of exactly C characters, NOT SEPARATED by spaces, representing the matrix after the fill operation has been finished.
Constraints
0 < R, C < 20 
0 <= startRow < R 
0 <= startCol < C
All symbols in the input matrix will be lowercase alphanumerics (a-z, 0-9). The fillChar will also be alphanumeric and lowercase.
The total running time of your program should be no more than 0.1s
The total memory allowed for use by your program is 5MB
Examples
Example Input	Expected Output
5 3
a a a
a a a
a b a
a b a
a b a
x
0 0	xxx
xxx
xbx
xbx
xbx
5 3
a a a
a a a
a b a
a b a
a b a
x
2 1	aaa
aaa
axa
axa
axa
5 6
o o 1 1 o o
o 1 o o 1 o
1 o o o o 1
o 1 o o 1 o
o o 1 1 o o
3
2 1	oo11oo
o1331o
133331
o1331o
oo11oo
5 6
o o o o o o
o o o 1 o o
o o 1 o 1 1
o 1 1 w 1 o
1 o o o o o
z
4 1	oooooo
ooo1oo
oo1o11
o11w1z
1zzzzz
5 6
o 1 o o 1 o
o 1 o o 1 o
o 1 1 1 1 o
o 1 o w 1 o
o o o o o o
z
4 0	z1oo1z
z1oo1z
z1111z
z1zw1z
zzzzzz

Hints
For some of the tests you can solve the problem with naive approach, however complete solution can be obtained by using Stack, Queue, DFS or BFS – go search on the internet. 
