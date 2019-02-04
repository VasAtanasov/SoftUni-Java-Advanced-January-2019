# Lab: Defining Classes

Problems for exercises and homework for the "Java Advanced" course @ SoftUni.

You can check your solutions here: https://judge.softuni.bg/Contests/Practice/Index/1517.

## Part I: Defining Classes

### 1. Car Info

Create a class named Car.

The class should have public fields for:

- Make: String
- Model: String
- Horse Power: int

Create a new class and ensure proper naming

![](../../resources/L13DefiningClasses/media/image1.png)
 
Define the fields

![](../../resources/L13DefiningClasses/media/image2.png)
 
Create a Test client in the same package
 
![](../../resources/L13DefiningClasses/media/image3.png)

You should be now able to use your class

![](../../resources/L13DefiningClasses/media/image4.png)
 
### Private Fields

Change the access modifiers of all class fields to private.

When done go back to the main method you should have compilation errors, like this:

![](../../resources/L13DefiningClasses/media/image5.png)

### Getters and Setters

Create getters and setters for each class field. 

Getter for the car make:
 
![](../../resources/L13DefiningClasses/media/image6.png)

Setter for the car make:

![](../../resources/L13DefiningClasses/media/image7.png)

Do the same for all the fields.

### Fix main method

You should set and get the values by using the correct methods

![](../../resources/L13DefiningClasses/media/image8.png)
 
### Create Car Info Method

This method should return the info about any car object in the following format:

"The car is: {made} {model} – {horsePower} HP."

You have to figure out how to create a method and to use it in the outside code as shown below

![](../../resources/L13DefiningClasses/media/image9.png)

### Test The Program 

Read a cars objects, add them to collection of your chose and the print each one on the console using the carInfo() method. The input consists of single integer N the number of lines representing car objects. One each line you will read car info in the following format {make} {model} - {horsePower} separated by single space.

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
<td>3<br>Chevrolet Impala 390<br>Luskava Jigula 500<br>Golqma Kola 49</td>
<td>The car is: Chevrolet Impala - 390 HP.<br>The car is: Luskava Jigula - 500 HP.<br>The car is: Golqma Kola - 49 HP.</td>
</tr>
<tr>
<td>5<br>This Car 1<br>Was Made 2<br>Only For 3<br>Test Purposes 4<br>No Way 5</td>
<td>The car is: This Car - 1 HP.<br>The car is: Was Made - 2 HP.<br>The car is: Only For - 3 HP.<br>The car is: Test Purposes - 4 HP.<br>The car is: No Way - 5 HP.</td>
</tr>
</tbody>
</table>

<p><b>Solution: <a href="./car">Car Constructors</a></b></p>
 
## Part II: Constructors

### 2. Car Constructors

Make proper constructors for the Car class so you can create car objects with different type of input information.
If you miss information about field of type String set the value to "unknown", and for integer field set -1.

First declare constructor which takes only the car make as parameter:

![](../../resources/L13DefiningClasses/media/image10.png)

Also create constructor which sets all the fields:

![](../../resources/L13DefiningClasses/media/image11.png)

Read information about car the same way as the previous task, however this time use constructors to create the objects, not creating object with the default constructor. You should be able to handle different types of input, the format will be the same as the previous task, but this time some of the data may be missing. For an example you can get only the car make – which means you have to set the car model to "unknown" and the Horse Power value to -1. There will be lines with complete car data, declare constructor which sets all the fields. 
You have to add the car objects to a collection of your chose and print the data as in the previous task. The input will always have one or three elements on each line.

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
<td>2<br>Chevrolet<br>Golqma Kola 49</td>
<td>The car is: Chevrolet unknown - -1 HP.<br>The car is: Golqma Kola - 49 HP.</td>
</tr>
<tr>
<td>4<br>Was<br>Only For 3<br>Test Purposes 4<br>No Way 5</td>
<td>The car is: Was unknown - -1 HP.<br>The car is: Only For - 3 HP.<br>The car is: Test Purposes - 4 HP.<br>The car is: No Way - 5 HP.</td>
</tr>
</tbody>
</table>

<p><b>Solution: <a href="./car">Car Constructors</a></b></p>

### 3. Bank Account

Create class BankAccount.

The class should have private fields for:

- Id: int (Starts from 1 and increments for every new account)
- Balance: double
- Interest rate: double (Shared for all accounts. Default value: 0.02)

The class should also have public methods for:

- setInterestRate(double interest): void (static)
- getInterest(int Years): double
- deposit(double amount): void

Create a test client supporting the following commands:

- Create
- Deposit {Id} {Amount}
- SetInterest {Interest}
- GetInterest {ID} {Years}
- End

### Examples

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
<td>Create<br>Deposit 1 20<br>GetInterest 1 10<br>End</td>
<td>Account ID1 created<br>Deposited 20 to ID1<br>4.00</td>
<td></td>
</tr>
<tr>
<td>Create<br>Create<br>Deposit 1 20<br>Deposit 3 20<br>Deposit 2 10<br>SetInterest 1<br>GetInterest 1 1<br>GetInterest 2 1<br>GetInterest 3 1<br>End</td>
<td>Account ID1 created<br>Account ID2 created<br>Deposited 20 to ID1<br>Account does not exist<br>Deposited 10 to ID2<br>20.00<br>10.00<br>Account does not exist</td>
<td>Sets the global interest rate to 1.<br>Prints interest for bank account with id 1 for 1 year period.</td>
</tr>
</tbody>
</table>

### Solution

Create the class as usual and create a constant for the default interest rate

![](../../resources/L13DefiningClasses/media/image12.png) 

Create the static and non-static fields, all private

![](../../resources/L13DefiningClasses/media/image13.png)
 
Set the id of an account upon creation while incrementing the global account count

![](../../resources/L13DefiningClasses/media/image14.png)
 
Create a setter for the global interest rate. Making the method static will let you access it through the class name

![](../../resources/L13DefiningClasses/media/image15.png)
 
Implement deposit() and getInterest()

![](../../resources/L13DefiningClasses/media/image16.png)

<p><b>Solution: <a href="./bank">Bank Account</a></b></p>

<p><b>Document with tasks description: <a href="../../resources/L13DefiningClasses/06. Java-OOP-Basics-Defining-Classes-Lab.docx">06. Java-OOP-Basics-Defining-Classes-Lab.docx</a></b></p>