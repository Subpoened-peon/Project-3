#CS 361: Project 3 (Turing Machines)  
* Authors: Nicholas Merritt, Kai Sorensen
* Class: CS361 Section 001
* Semester: Fall 2023

## Overview
This project simulates a Turing machine that is tasked with running a set of intructions specified in an external file.

## Reflection
Biggest issue that we ran into in this project was interpeting the directions. These directions actually required close examination, which we were not in the mindset to give. However, once the diections were clarified to us, we got the project done in about two hours. We felt like our confidence in programming increased with this project as most of our code worked as intended on the first try. In computer science, it seems like programming is the easy part of the job; it's understanding the problem that takes considerable effort and time. That's why we study theory, perhaps.

## Compiling and Using

To run this code, open the main project directory in a linux terminal.

Compilation command:
```
find . -name "*.java" -exec javac {} +
```

To run the machine on a file:
```
java fa.tm.TMSimulator [file name] [optional starting tape]
``` 

## Sources Used
Dr. Frost: she explained the directins. Formally, the whole squa' is sending prayers up.
