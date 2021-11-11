# Project 3: Hash Table Playground

* Author: Sawyer Ball
* Class: CS321 Section 1
* Semester: Fall 2021

## Overview

This program creates HashTables using HashObjects that are also defined
within this program. These tables can be made using two different hash
functions: Linear Probing and Double Hashing.

## Reflection

This project was a lot more confusing to me than others. Hash tables are
really cool to me so it's annoying that it's taking me this much time
to figure it out. The part that is the most confusing to me right now is
the hash functions but I was able to make enough sense of them to get them
to work in this project.

Other than these main difficulties, the project went fairly well other
than the occasional bug that I was generally able to debug in a short
amount of time. Overall, this project did further my understanding of
Hash Tables and how they work.

## Compiling and Using

To compile and use the program, open terminal and navigate to the project
folder. Compile by running the following command:

``javac HashtableTest.java``

You can then use the code by running the following command with arguments:

``java HashtableTest <input type> <load factor> [<debug level>]``

Input type must be either 1 for random numbers, 2 for system time, or
3 for word list. The load factor must be a number between 0 and 1. The
debug level must be 0 to print to console, 1 to print to console and 
print a dump file, or 2 to print every 100 entries to console.

## Results

Input source 1: random number

alpha   linear    double
-----------------------------
0.5      1.500     1.385
0.6      1.747     1.521
0.7      2.167     1.719
0.8      2.948     2.011
0.9      5.343     2.565
0.95    10.703     3.131
0.98    23.444     3.976
0.99    50.594     4.672


Input source 2: current time

alpha        linear    double
-----------------------------
0.5          1.0       1.0
0.6          1.0       1.0
0.7          1.0       1.0
0.8          1.0       1.0
0.9          1.0       1.0
0.95         1.0       1.0
0.98         1.0       1.0
0.99         1.0       1.0


Input source 3: word-list

alpha   linear    double
-----------------------------
0.5      1.597     1.390
0.6      2.149     1.534
0.7      3.604     1.721
0.8      6.708     2.016
0.9     19.815     2.569
0.95   110.594     3.186
0.98   324.206     4.020
0.99   471.671     4.696


## Sources used

The only sources used for this program were from class notes or
instructions.

----------
