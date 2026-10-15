# Student Performance Tracking Application

A console-based Java application for managing student records and analyzing academic performance.

## Features

- Add students with unique IDs
- View all student records
- Search students by ID
- Update student names and marks
- Delete student records
- Validate IDs, names, and marks
- Sort students by marks in descending order
- Generate a performance report with average, highest scorer, lowest scorer, pass count, and fail count

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- ArrayList and Java Collections
- Comparator
- Exception-free validation for supported inputs

## Requirements

- JDK 21 or a compatible Java version
- Visual Studio Code or another Java-compatible editor

## How to Run

Open a terminal in the project root and run:

```bash
javac -d out src/Student.java src/Main.java
java -cp out Main
```

## Project Structure

```text
StudentPerformanceTracking/
├── src/
│   ├── Main.java
│   └── Student.java
├── out/
└── README.md
```

## Current Limitations

- Student records are stored in memory and are lost when the application exits.
- Persistent database storage is not included in this version.
- Handling of non-numeric console input requires further hardening.

## Learning Outcomes

Practiced Java classes, constructors, encapsulation, collections, loops, conditional statements, CRUD-style operations, sorting, and basic performance calculations.