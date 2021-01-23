# What should I get in final exam?

<h3>What is this?</h3>
All universities have their own grading system. Some of them are using the Letter grading system.

- AA 4.0
- BA 3.5
- BB 3.0
- etc.

At the last of the semester, students get one of these letters for their\`s average for each lesson.

**What is this project for?**

This project helps students to calculate their letters of lessons for their averages.

**How to use it?**
- First clone the project with (or you can fork it) : 
```
git clone https://github.com/ParvinEyvazov/what-should-I-get-in-final-exam.git
```
- Create or modify an input file called \`grades.txt\`.

The text file has its own format. 1 subject has to be written according to like this:
```
<Subject name 1>
<quiz/homework/midterm>,<percentage of it>,<grade>
<another quiz/homework/midterm>,<percentage of it>,<grade>
<another quiz/homework/midterm>,<percentage of it>,<grade>
--
<Subject name 2>
<quiz/homework/midterm>,<percentage of it>,<grade>
<another quiz/homework/midterm>,<percentage of it>,<grade>
<another quiz/homework/midterm>,<percentage of it>,<grade>
--
```

- Compile the code

```
javac main.java
```

- Run the code

```
java main grades.txt
```

- Get the result

```
File Organization and Processing
For AA --> 93.09 and more
For BA --> 80.36 and more
For BB --> 67.64 and more
For CB --> 54.91 and more
For CC --> 42.18 and more
For DC --> 29.45 and more (lower than 35 rule)
For DD --> 16.73 and more (lower than 35 rule)
For FD --> -3.27 and more (lower than 35 rule)

Introduction to Machine Learning
For AA --> 120.44 and more
For BA --> 104.89 and more
For BB --> 89.33 and more
For CB --> 73.78 and more
For CC --> 58.22 and more
For DC --> 42.67 and more
For DD --> 27.11 and more (lower than 35 rule)
For FD --> 2.67 and more (lower than 35 rule)
```
Output file shows that what student has to get in the final exam for according letter grades.

> **Note**: lower than 35 rule is a rule of the university that if students get lower than 35 in the final exam, they automatically fail in the semester for this lesson.
