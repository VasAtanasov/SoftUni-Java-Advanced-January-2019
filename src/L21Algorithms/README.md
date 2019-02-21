# Exercises: Basic Algorithms

Problems for exercises and homework for the "Java Advanced" course @ SoftUni.

### 1. Recursive Array Sum

Write a program that finds the sum of all elements in an integer array. Use recursion.

Note: In practice recursion should not be used here (instead use an iterative solution), this is just an exercise.

### Examples

<table>
<thead>
<tr>
<th>Input</th>
<th>Output</th>
</tr>
</thead>
<tbody>
<tr>
<td>1 2 3 4</td>
<td>10</td>
</tr>
<tr>
<td>-1 0 1</td>
<td>0</td>
</tr>
</tbody>
</table>

### Hints

Write a recursive method. It will take as arguments the input array and the current index. 

- The method should return the current element + the sum of all next elements (obtained by recursively calling it).
- The recursion should stop when there are no more elements in the array.

<p><b>Solution: <a href="./Ex01RecursiveArraySum">Recursive Array Sum</a></b></p>

### 2. Recursive Factorial

Write a program that finds the factorial of a given number. Use recursion.

Note: In practice recursion should not be used here (instead use an iterative solution), this is just an exercise.

### Examples

<table>
<thead>
<tr>
<th>Input</th>
<th>Output</th>
</tr>
</thead>
<tbody>
<tr>
<td>5</td>
<td>120</td>
</tr>
<tr>
<td>10</td>
<td>3628800</td>
</tr>
</tbody>
</table>

### Hints

Write a recursive method. It will take as arguments an integer number.

- The method should return the current element * the result of calculating factorial of current element - 1 (obtained by recursively calling it).
- The recursion should stop when there are no more elements in the array.

<p><b>Solution: <a href="./Ex02RecursiveFactorial">Recursive Factorial</a></b></p>

### 3. Sum of Coins

Let’s have a range of possible coin values (e.g. 1, 2, 5, 10, 20, 50) and a desired sum. In this problem, the goal is to reach the sum using as few coins as possible using a greedy approach. We’ll assume that each coin value and the desired sum are integers, but we can easily modify the problem to accommodate floating-point values.

### Examples:

<table>
<thead>
<tr>
<th>Input</th>
<th>Output</th>
<th>Comments</th>
</tr>
</thead>
<tbody>
<tr>
<td>Coins: 1, 2, 5, 10, 20, 50<br>Sum: 923</td>
<td>Number of coins to take: 21<br>18 coin(s) with value 50<br>1 coin(s) with value 20<br>1 coin(s) with value 2<br>1 coin(s) with value 1</td>
<td>18*50 + 1*20 + 1*2 + 1*1 = 900 + 20 + 2 + 1 = 923</td>
</tr>
<tr>
<td>Coins: 1<br>Sum: 42</td>
<td>Number of coins to take: 42<br>42 coin(s) with value 1</td>
<td></td>
</tr>
<tr>
<td>Coins: 3, 7<br>Sum: 11</td>
<td>Error</td>
<td>Cannot reach desired sum with these coin values</td>
</tr>
<tr>
<td>Coins: 1, 2, 5<br>Sum: 2031154123</td>
<td>Number of coins to take: 406230826<br>406230824 coin(s) with value 5<br>1 coin(s) with value 2<br>1 coin(s) with value 1</td>
<td>Solution should be fast enough to handle a combination of small coin values and a large desired sum</td>
</tr>
<tr>
<td>Coins: 1, 9, 10<br>Sum: 27</td>
<td>Number of coins to take: 9<br>2 coin(s) with value 10<br>7 coin(s) with value 1</td>
<td>Greedy approach produces non-optimal solution (9 coins to take instead of 3 with value 9)</td>
</tr>
</tbody>
</table>

#### Greedy Approach to Solution

For this problem, a greedy algorithm will attempt to take the best possible coin value (which is the largest), then take the next largest coin value and so on, until the sum is reached or there are no coin values left.

There may be a different amount of coins to take for each value. In one of the examples above we had a very large desired sum and relatively small coin values, which means we’ll need to take a lot of coins. It would not be efficient (and may even cause an Exception) if we return the result as a List<Integer>; a more practical way to do it is to use a Map<Integer, Integer> where the keys are the coin values and the values are the number of coins to take for the specified coin value. Therefore, in the second example (coin values = { 1 }, sum = 42), instead of returning a list with 42 elements in it, we’ll return a dictionary with a single key-value pair: 1 => 42.

<p><b>Solution: <a href="./Ex03SumOfCoins">Sum of Coins</a></b></p>

### 4. Sorting

Implement any or many of the following sorting algorithms:

- Insertions Sort
- Bubble Sort
- Shell Sort 
- Merge Sort
- Quicksort
- Bucket Sort

Read a sequence of numbers from the console, sort them and print them back.

### Examples

<table>
<thead>
<tr>
<th>Input</th>
<th>Output</th>
</tr>
</thead>
<tbody>
<tr>
<td>5 4 3 2 1</td>
<td>1 2 3 4 5</td>
</tr>
<tr>
<td>1 4 2 -1 0</td>
<td>-1 0 1 2 4</td>
</tr>
</tbody>
</table>

Here is a breakdown of judge tests:

<table>
<thead>
<tr>
<th>Test N</th>
<th>N of Elements</th>
<th>Comments</th>
</tr>
</thead>
<tbody>
<tr>
<td>001</td>
<td rowspan="4"></td>
<td>Random</td>
</tr>
<tr>
<td>002</td>
<td align="center">1K</td>
<td>Sorted</td>
</tr>
<tr>
<td>003</td>
<td></td>
<td>Reversed</td>
</tr>
<tr>
<td>004</td>
<td></td>
<td>Duplicate</td>
</tr>
<tr>
<td>005</td>
<td rowspan="4"></td>
<td>Random</td>
</tr>
<tr>
<td>006</td>
<td align="center">10K</td>
<td>Sorted</td>
</tr>
<tr>
<td>007</td>
<td></td>
<td>Reversed</td>
</tr>
<tr>
<td>008</td>
<td></td>
<td>Duplicate</td>
</tr>
<tr>
<td>009</td>
<td rowspan="4"></td>
<td>Random</td>
</tr>
<tr>
<td>010</td>
<td align="center">100K</td>
<td>Sorted</td>
</tr>
<tr>
<td>011</td>
<td></td>
<td>Reversed</td>
</tr>
<tr>
<td>012</td>
<td></td>
<td>Duplicate</td>
</tr>
</tbody>
</table>

<p><b>Solution: <a href="./Ex04Sorting">Sorting</a></b></p>

### 5. Searching

Implement any or many of the following sorting algorithms:

- Linear Search
- Binary Search
- Fibonacci Search

Read a sequence of numbers on the first line and a single number on the second from the console. Find the index of the number in the given array. return -1 if the element is not present in the array.

### Examples

<table>
<thead>
<tr>
<th>Input</th>
<th>Output</th>
</tr>
</thead>
<tbody>
<tr>
<td>1 2 3 4 5<br>1</td>
<td>0</td>
</tr>
<tr>
<td>1 2 3 4 5<br>6</td>
<td>-1</td>
</tr>
</tbody>
</table>

<p><b>Solution: <a href="./Ex05Searching">Searching</a></b></p>

<p><b>Document with tasks description: <a href="../../resources/L21Algorithms/10. Workshop-Basic-Algorithms-Lab.docx">10. Workshop-Basic-Algorithms-Lab.docx</a></b></p>