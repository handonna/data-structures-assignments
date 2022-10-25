# Assignment 1: Java Warmup

In assignment 1, you will write a simple program to learn and practice Java.  

The program you write will implement a "Summer" class which, intuitively, keeps track
of a sequence of integers and can print stats about the integers, such as their sum.

## Task 1: Implement the Summer constructor and the following methods in Summer.java:

```  
  public void add (int n)
  public int count ()
  public int sum ()
  public int high ()
  public int low ()
  public double average ()
  public double avgOver (int n)
```

The basic spec consists of two classes, each of which are provided in .java files
in the repo for assignment 1.  The first class, A1Main, contains the main method.  The second
class, Summer, contains several incomplete functions for you to implement.  Details for 
implementing each function are provided in Summer.java.  Note that your code will not initially 
compile because the functions above with non-void return types don't return anything.

> **Hint:** Before you attempt Task 2, you may wish to test your methods out in main by creating a 
> Summer object, adding some integers to it, and checking the resulting stats like sum, count, etc.  

> **Hint:** You may wish to add fields to Summer.java or additional methods to make your implementations easier.
## Task 2: Configure main in A1Main.java to read input and print separate stats for even and odd integers

In Task 2, you will practice reading input from a Scanner and instantiating Summer objects.  Specifically,
your main method will do the following:

* Create a scanner to get input from the keyboard (already provided in the code)
* Create two objects of class Summer
* Retrieve the first input from the keyboard using the scanner and use that as the number of items to process
* For the remaining keyboard input, use one Summer object to collect even integers we type as input and the other Summer object to collect odd integers
* Print out the following stats for the even integers, followed by stats for the odd integers using the format in the examples below.  To simplify the testing, in addition to the sum, largest, smallest, etc. stats, we'll test the avgOver method by printing the average for integers over 10.

> **Hint:** A helper method, printStats, is provided to help you format your output to match the format in the examples.

> **Hint:** If you wrote any tests in main.java for Task 1, you will need to comment those out when you submit the assignment to gradescope for Task 2 to be tested correctly.  The autograder will provide input via the scanner and expect the output to be formatted as in the examples below. 

**Example 1:**
Suppose we have the following sample input from the keyboard.


```
10
1
5
11
15
33
22
4
8
12
2
```
This says 10 ints are coming, and those ints are 1, 5, 11 etc. to 2.  Your main method would then print the following stats.

Sample output:
```
Number of evens: 5
Sum of evens: 48
Average of evens: 9.6
Largest even: 22
Smallest even: 2
Average of evens over 10: 17.0 
Number of odds: 5
Sum of odds: 65
Average of odds: 13.0
Largest odd: 33
Smallest odd: 1
Average of odds over 10: 19.666666666666668
```

**Example 2:**
Suppose we have the following input.
```
6
-10
-100
-3
5
19
-17
```
In this case, we'd expect the following sample output.
```
Number of evens: 2
Sum of evens: -110
Average of evens:-55.0
Largest even: -10
Smallest even: -100
Average of evens over 10: 0.0
Number of odds: 4
Sum of odds: 4
Average of odds:1.0
Largest odd: 19
Smallest odd: -17
Average of odds over 10: 19.0
```

Note that in the avgOver method, if there are no numbers over the threshold
(we are using 10 here) then you cannot divide by 0.  Your code must 
detect this, and in this case return 0.0 for the avgOver value.

> **Hint** Note that the main method contains more clues for processing the input step by step.

> **Hint** You can test your code for Task 2 by running your program in IntelliJ and inputting each number from the examples into the IntelliJ terminal
> one by one.

### Background and intuition for Task 2

The main class will do all input handling and
produce all output.
When input is obtained it will decide which of the two Summer
objects to interact with.

The Summer class can be thought of as a pattern for data handling objects.
An object of class Summer does not care what data it is sent
(using the add method) as long as the data is in type int.
It should save the ints sent to it in an internal, private array
data items will be sent one at a time and each time add method
is called the object will simply put the value into an open
array slot.  Then at any time when other methods are called, the
object computes some simple stats over the array of data and 
returns the requested information.


When thinking about how to implement Task 2, remember that main should create 2 Summers and then decide (with your code in main) 
which object to "talk to" based on the even or odd criterion of the input value.
