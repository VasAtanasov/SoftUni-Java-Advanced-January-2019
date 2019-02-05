# Exercises: Defining Classes

Problems for exercises and homework for the "Java Advanced" course @ SoftUni.
You can check your solutions here: https://judge.softuni.bg/Contests/1518 .

Note: For this exercises you are allowed to have multiple classes in the same file.

### 1. Opinion Poll

Create Person class with two fields String name and int age, write a program that reads from the console N lines of personal information and then prints all people whose age is more than 30 years, sorted in alphabetical order.

Note: you can use stream() to filter people.

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
<td>3<br>Pesho 12<br>Stamat 31<br>Ivan 48</td>
<td>Ivan - 48<br>Stamat – 31</td>
</tr>
<tr>
<td>5<br>Nikolai 33<br>Yordan 88<br>Tosho 22<br>Lyubo 44<br>Stanislav 11</td>
<td>Lyubo - 44<br>Nikolai - 33<br>Yordan – 88</td>
</tr>
</tbody>
</table>

<p><b>Solution: <a href="./Ex01OpinionPoll">Opinion Poll</a></b></p>

### 2. Company Roster

Define a class Employee that holds the following information: name, salary, position, department, email and age. The name, salary, position and department are mandatory while the rest are optional. 
Your task is to write a program which takes N lines of employees from the console and calculates the department with the highest average salary and prints for each employee in that department his name, salary, email and age – sorted by salary in descending order. If an employee doesn’t have an email – in place of that field you should print “n/a” instead, if he doesn’t have an age – print “-1” instead. The salary should be printed to two decimal places after the seperator.

Hint: you can define a Department class that holds list of employees.

<table>
<thead>
<tr>
<th>Input</th>
<th>Output</th>
</tr>
</thead>
<tbody>
<tr>
<td>4<br>Pesho 120.00 Dev Development pesho@abv.bg 28<br>Toncho 333.33 Manager Marketing 33<br>Ivan 840.20 ProjectLeader Development ivan@ivan.com<br>Gosho 0.20 Freeloader Nowhere 18</td>
<td>Highest Average Salary: Development<br>Ivan 840.20 ivan@ivan.com -1<br>Pesho 120.00 pesho@abv.bg 28</td>
</tr>
<tr>
<td>6<br>Stanimir 496.37 Temp Coding stancho@yahoo.com<br>Yovcho 610.13 Manager Sales<br>Toshko 609.99 Manager Sales toshko@abv.bg 44<br>Venci 0.02 Director BeerDrinking beer@beer.br 23<br>Andrei 700.00 Director Coding<br>Popeye 13.3333 Sailor SpinachGroup popeye@pop.ey</td>
<td>Highest Average Salary: Sales<br>Yovcho 610.13 n/a -1<br>Toshko 609.99 toshko@abv.bg 44</td>
</tr>
</tbody>
</table>

<p><b>Solution: <a href="./Ex02CompanyRoster">Company Roster</a></b></p>

### 3. \*Speed Racing

Your task is to implement a program that keeps track of cars and their fuel and supports methods for moving the cars. Define a class Car that keeps track of a car’s Model, fuel amount, fuel cost for 1 kilometer and distance traveled. A Car’s Model is unique - there will never be 2 cars with the same model.
On the first line of the input you will receive a number N – the number of cars you need to track, on each of the next N lines you will receive information for a car in the following format “\<Model> \<FuelAmount> \<FuelCostFor1km>”, all cars start at 0 kilometers traveled.

After the N lines until the command “End” is received, you will receive a commands in the following format “Drive \<CarModel>  \<amountOfKm>”, implement a method in the Car class to calculate whether or not a car can move that distance, if it can the car’s fuel amount should be reduced by the amount of used fuel and its distance traveled should be increased by the amount of kilometers traveled, otherwise the car should not move (Its fuel amount and distance traveled should stay the same) and you should print on the console “Insufficient fuel for the drive”. After the “End” command is received, print each car in order of appearing in input and its current fuel amount and distance traveled in the format “<Model> <fuelAmount>  <distanceTraveled>”, where the fuel amount should be printed to two decimal places after the separator.

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
<td>2<br>AudiA4 23 0.3<br>BMW-M2 45 0.42<br>Drive BMW-M2 56<br>Drive AudiA4 5<br>Drive AudiA4 13<br>End</td>
<td>AudiA4 17.60 18<br>BMW-M2 21.48 56</td>
</tr>
<tr>
<td>3<br>AudiA4 18 0.34<br>BMW-M2 33 0.41<br>Ferrari-488Spider 50 0.47<br>Drive Ferrari-488Spider 97<br>Drive Ferrari-488Spider 35<br>Drive AudiA4 85<br>Drive AudiA4 50<br>End</td>
<td>Insufficient fuel for the drive<br>Insufficient fuel for the drive<br>AudiA4 1.00 50<br>BMW-M2 33.00 0<br>Ferrari-488Spider 4.41 97</td>
</tr>
</tbody>
</table>

<p><b>Solution: <a href="./Ex03SpeedRacing">Speed Racing</a></b></p>

### 4. Raw Data

You are the owner of a courier company and want to make a system for tracking your cars and their cargo. Define a class Car that holds information about model, engine, cargo and a collection of exactly 4 tires. The engine, cargo and tire should be separate classes, create a constructor that receives all information about the Car and creates and initializes its inner components (engine, cargo and tires).
On the first line of input you will receive a number N - the number of cars you have, on each of the next N lines you will receive information about a car in the format “\<Model> \<EngineSpeed> \<EnginePower> \<CargoWeight> \<CargoType> \<Tire1Pressure> \<Tire1Age> \<Tire2Pressure> \<Tire2Age> \<Tire3Pressure> \<Tire3Age> \<Tire4Pressure> \<Tire4Age>” where the speed, power, weight and tire age are integers, tire pressure is a double. 
After the N lines you will receive a single line with one of 2 commands “fragile” or “flamable” , if the command is “fragile” print all cars whose Cargo Type is “fragile” with a tire whose pressure is  < 1, if the command is “flamable” print all cars whose Cargo Type is “flamable” and have Engine Power > 250. The cars should be printed in order of appearing in the input.	

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
<td>2<br>ChevroletAstro 200 180 1000 fragile 1.3 1 1.5 2 1.4 2 1.7 4<br>Citroen2CV 190 165 1200 fragile 0.9 3 0.85 2 0.95 2 1.1 1<br>fragile</td>
<td>Citroen2CV</td>
</tr>
<tr>
<td>4<br>ChevroletExpress 215 255 1200 flamable 2.5 1 2.4 2 2.7 1 2.8 1<br>ChevroletAstro 210 230 1000 flamable 2 1 1.9 2 1.7 3 2.1 1<br>DaciaDokker 230 275 1400 flamable 2.2 1 2.3 1 2.4 1 2 1<br>Citroen2CV 190 165 1200 fragile 0.8 3 0.85 2 0.7 5 0.95 2<br>flamable</td>
<td>ChevroletExpress<br>DaciaDokker</td>
</tr>
</tbody>
</table>

<p><b>Solution: <a href="./Ex04RawData">Raw Data</a></b></p>

### 5. Car Salesman

Define two classes Car and Engine. A Car has a model, engine, weight and color. An Engine has model, power, displacement and efficiency. A Car’s weight and color and its Engine’s displacements and efficiency are optional. 
On the first line, you will read a number N which will specify how many lines of engines you will receive, on each of the next N lines you will receive information about an Engine in the following format “\<Model> \<Power> \<Displacement> \<Efficiency>”. After the lines with engines, on the next line you will receive a number M – specifying the number of Cars that will follow, on each of the next M lines information about a Car will follow in the following format “\<Model> \<Engine> \<Weight> \<Color>”, where the engine in the format will be the model of an existing Engine. When creating the object for a Car, you should keep a reference to the real engine in it, instead of just the engine’s model, note that the optional properties might be missing from the formats.
Your task is to print each car (in the order you received them) and its information in the format defined bellow, if any of the optional fields has not been given print “n/a” in its place instead:

    <CarModel>:
    <EngineModel>:
    Power: <EnginePower>
    Displacement: <EngineDisplacement>
    Efficiency: <EngineEfficiency>
    Weight: <CarWeight>
    Color: <CarColor>
        
### Optional

Override the classes’s ToString() methods to have a reusable way of displaying the objects.

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
<td>2<br>V8-101 220 50<br>V4-33 140 28 B<br>3<br>FordFocus V4-33 1300 Silver<br>FordMustang V8-101<br>VolkswagenGolf V4-33 Orange</td>
<td>FordFocus:<br>V4-33:<br>Power: 140<br>Displacement: 28<br>Efficiency: B<br>Weight: 1300<br>Color: Silver<br>FordMustang:<br>V8-101:<br>Power: 220<br>Displacement: 50<br>Efficiency: n/a<br>Weight: n/a<br>Color: n/a<br>VolkswagenGolf:<br>V4-33:<br>Power: 140<br>Displacement: 28<br>Efficiency: B<br>Weight: n/a<br>Color: Orange</td>
</tr>
<tr>
<td>4<br>DSL-10 280 B<br>V7-55 200 35<br>DSL-13 305 55 A+<br>V7-54 190 30 D<br>4<br>FordMondeo DSL-13 Purple<br>VolkswagenPolo V7-54 1200 Yellow<br>VolkswagenPassat DSL-10 1375 Blue<br>FordFusion DSL-13</td>
<td>FordMondeo:<br>DSL-13:<br>Power: 305<br>Displacement: 55<br>Efficiency: A+<br>Weight: n/a<br>Color: Purple<br>VolkswagenPolo:<br>V7-54:<br>Power: 190<br>Displacement: 30<br>Efficiency: D<br>Weight: 1200<br>Color: Yellow<br>VolkswagenPassat:<br>DSL-10:<br>Power: 280<br>Displacement: n/a<br>Efficiency: B<br>Weight: 1375<br>Color: Blue<br>FordFusion:<br>DSL-13:<br>Power: 305<br>Displacement: 55<br>Efficiency: A+<br>Weight: n/a<br>Color: n/a</td>
</tr>
</tbody>
</table>

<p><b>Solution: <a href="./Ex05CarSalesman">Car Salesman</a></b></p>

### 6. Pokémon Trainer

You wanna be the very best pokemon trainer, like no one ever was, so you set out to catch pokemon. Define a class Trainer and a class Pokemon. Trainers have a name, number of badges and a collection of pokemon, Pokemon have a name, an element and health, all values are mandatory. Every Trainer starts with 0 badges.
From the console you will receive an unknown number of lines until you receive the command “Tournament”, each line will carry information about a pokemon and the trainer who caught it in the format “\<TrainerName> \<PokemonName> \<PokemonElement> \<PokemonHealth>” where TrainerName is the name of the Trainer who caught the pokemon, names are unique there cannot be 2 trainers with the same name. After receiving the command “Tournament” an unknown number of lines containing one of three elements “Fire”, “Water”, “Electricity” will follow until the command “End” is received. For every command you must check if a trainer has atleast 1 pokemon with the given element, if he does he receives 1 badge, otherwise all his pokemon lose 10 health, if a pokemon falls to 0 or less health he dies and must be deleted from the trainer’s collection. After the command “End” is received you should print all trainers sorted by the amount of badges they have in descending order (if two trainers have the same amount of badges they should be sorted by order of appearance in the input) in the format “\<TrainerName> \<Badges> \<NumberOfPokemon>”.

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
<td>Pesho Charizard Fire 100<br>Gosho Squirtle Water 38<br>Pesho Pikachu Electricity 10<br>Tournament<br>Fire<br>Electricity<br>End</td>
<td>Pesho 2 2<br>Gosho 0 1</td>
</tr>
<tr>
<td>Stamat Blastoise Water 18<br>Nasko Pikachu Electricity 22<br>Jicata Kadabra Psychic 90<br>Tournament<br>Fire<br>Electricity<br>Fire<br>End</td>
<td>Nasko 1 1<br>Stamat 0 0<br>Jicata 0 1</td>
</tr>
</tbody>
</table>

<p><b>Solution: <a href="./Ex06PokemonTrainer">Pokémon Trainer</a></b></p>

### 7. Google

Google is always watching you, so it should come as no surprise that they know everything about you (even your pokemon collection), since you’re really good at writing classes Google asked you to design a Class that can hold all the information they need for people.

From the console you will receive an unkown amount of lines until the command “End” is read, on each of those lines there will be information about a person in one of the following formats:

- “\<Name> company \<companyName> \<department> \<salary>”
- “\<Name> pokemon \<pokemonName> \<pokemonType>”
- “\<Name> parents \<parentName> \<parentBirthday>”
- “\<Name> children \<childName> \<childBirthday>”
- “\<Name> car \<carModel> \<carSpeed>”

You should structure all information about a person in a class with nested subclasses. People’s names are unique - there won’t be 2 people with the same name, a person can also have only 1 company and car, but can have multiple parents, chidlren and pokemon. After the command “End” is received on the next line you will receive a single name, you should print all information about that person. Note that information can change during the input, for instance if we receive multiple lines which specify a person’s company, only the last one should be the one remembered. The salary must be formated to two decimal places after the seperator.

Note: print the information in format:

    {personName}
    Company:
    {companyName} {companyDepartment} {salary}
    ...
    Children:
    {childName} {childBirthday}
    {childName} {childBirthday}

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
<td>PeshoPeshev company PeshInc Management 1000.00<br>TonchoTonchev car Trabant 30<br>PeshoPeshev pokemon Pikachu Electricity<br>PeshoPeshev parents PoshoPeshev 22/02/1920<br>TonchoTonchev pokemon Electrode Electricity<br>End<br>TonchoTonchev</td>
<td>TonchoTonchev<br>Company:<br>Car:<br>Trabant 30<br>Pokemon:<br>Electrode Electricity<br>Parents:<br>Children:</td>
</tr>
<tr>
<td>JelioJelev pokemon Onyx Rock<br>JelioJelev parents JeleJelev 13/03/1933<br>GoshoGoshev pokemon Moltres Fire<br>JelioJelev company JeleInc Jelior 777.77<br>JelioJelev children PudingJelev 01/01/2001<br>StamatStamatov pokemon Blastoise Water<br>JelioJelev car AudiA4 180<br>JelioJelev pokemon Charizard Fire<br>End<br>JelioJelev</td>
<td>JelioJelev<br>Company:<br>JeleInc Jelior 777.77<br>Car:<br>AudiA4 180<br>Pokemon:<br>Onyx Rock<br>Charizard Fire<br>Parents:<br>JeleJelev 13/03/1933<br>Children:<br>PudingJelev 01/01/2001</td>
</tr>
</tbody>
</table>

<p><b>Solution: <a href="./Ex07Google">Google</a></b></p>

### 8. \*** Family Tree

You want to build your family tree, so you went to ask your grandmother, sadly your grandmother keeps remembering information about your predecessors in pieces, so it falls to you to group the information and build the family tree.
On the first line of the input you will receive either a name or a birthdate in the format “\<FirstName> \<LastName>” or “day/month/year” – your task is to find the person’s information in the family tree. On the next lines until the command “End” is received you will receive information about your predecessors that you will use to build the family tree. 
The information will be in one of the following formats: 

- “FirstName LastName - FirstName LastName”
- “FirstName LastName - day/month/year”
- “day/month/year - FirstName LastName”
- “day/month/year - day/month/year”
- “FirstName LastName day/month/year”

The first 4 formats reveal a family tie – the person on the left is parent to the person on the right (as you can see the format does not need to contain names, for example the 4th format means the person born on the left date is parent to the person born on the right date). The last format ties different information together – i.e. the person with that name was born on that date. Names and birthdates are unique – there won’t be 2 people with the same name or birthdate, there will always be enough entries to construct the family tree (all people’s names and birthdates are known and they have atleast one connection to another person in the tree). 
After the command “End” is received you should print all information about the person whose name or birthdate you received on the first line – his name, birthday, parents and children (check the examples for the format). The people in the parents and childrens lists should be ordered by their first appearance in the input (regardless if they appeared as a birthdate or a name, for example in the first input Stamat is before Penka because he first appeared in the second line, while she appears in the third.).

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
<td>Pesho Peshev<br>11/11/1951 - 23/05/1980<br>Penka Pesheva - 23/05/1980<br>Penka Pesheva 09/02/1953<br>Pesho Peshev - Gancho Peshev<br>Gancho Peshev 01/01/2005<br>Stamat Peshev 11/11/1951<br>Pesho Peshev 23/05/1980<br>End</td>
<td>Pesho Peshev 23/05/1980<br>Parents:<br>Stamat Peshev 11/11/1951<br>Penka Pesheva 09/02/1953<br>Children:<br>Gancho Peshev 01/01/2005</td>
</tr>
<tr>
<td>13/12/1993<br>25/03/1934 - 04/04/1961<br>Poncho Tonchev 25/03/1934<br>04/04/1961 - Moncho Tonchev<br>Toncho Tonchev - Lomcho Tonchev<br>Moncho Tonchev 13/12/1993<br>Lomcho Tonchev 07/07/1995<br>Toncho Tonchev 04/04/1961<br>End</td>
<td>Moncho Tonchev 13/12/1993<br>Parents:<br>Toncho Tonchev 04/04/1961<br>Children:</td>
</tr>
</tbody>
</table>

<p><b>Solution: <a href="./Ex08FamilyTree">Family Tree</a></b></p>

### 9. \**Cat Lady

Ginka has many cats in her house of various breeds, since some breeds have specific characteristics, Ginka needs some way to catalogue the cats, help her by creating a class hierarchy with all her breeds of cats so that she can easily check on their characteristics. Ginka has 3 specific breeds of cats “Siamese”, “Cymric” and the very famous bulgarian breed “Street Extraordinaire”,  each breed has a specific characteristic about which information should be kept. For the Siamese cats their ear size should be kept, for Cymric cats - the length of their fur in milimeters and for the Street Extraordinaire the decibels of their meowing during the night.
From the console you will receive lines of cat information until the command “End” is received, the information will come in one of the following formats:

- “Siamese \<name> \<earSize>”
- “Cymric \<name> \<furLength>”
- “StreetExtraordinaire \<name> \<decibelsOfMeows>”

On the last line after the “End” command you will receive the name of a cat, you should print that cat. Round the numbers two digits after the decimal separator.

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
<td>StreetExtraordinaire Maca 85<br>Siamese Sim 4<br>Cymric Tom 28<br>End<br>Tom</td>
<td>Cymric Tom 28.00</td>
</tr>
<tr>
<td>StreetExtraordinaire Koti 80<br>StreetExtraordinaire Maca 100<br>Cymric Tim 31<br>End<br>Maca</td>
<td>StreetExtraordinaire Maca 100.00</td>
</tr>
</tbody>
</table>

### Hint

Use class inheritance to represent the cat hierarchy and override the ToString() methods of concrete breeds to allow for easy printing of the cat, regardless what breed it is.

<p><b>Solution: <a href="./Ex09CatLady">Cat Lady</a></b></p>

<p><b>Document with tasks description: <a href="../../resources/L14DefiningClassesExercises/06. Java-OOP-Basics-Defining-Classes-Exercises.docx">06. Java-OOP-Basics-Defining-Classes-Exercises.docx</a></b></p>
