**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report #3 – Code Coverage, Adequacy Criteria and Test Case Correlation**

| Group \#:      |    28    |
| -------------- | ---      |
| Student Names: |          |
| Harshit Sharma | 30092470 |
| Heidi Toews    | 30094995 |
| Muhammad Khan  |          |
| Shamis Ali     |          |

(Note that some labs require individual reports while others require one report
for each group. Please see each lab document for details.)

# 1 Introduction

Text…

# 2 Manual data-flow coverage calculations for DataUtilities.calculateColumnTotal and Range.contains methods

## DataUtilities.calculateColumnTotal

Data flow diagram: 
![asn2DataUtilitiesDiagram](https://user-images.githubusercontent.com/81480268/156485739-7b29a0b5-49ff-4c98-88ca-7092254873ba.jpg)

Def-use sets: 
```
def(1) = {data, column, total, rowCount}
use(1) = {}

def(2) = {r}
use(2) = {r, column, rowCount, n}

def(3) = {}
use(3) = {}

def(4) = {total}
use(4) = {n, total}

def(5) = {}
use(5) = {r}

def(6) = {}
use(6) = {total}
```

DU-pairs per variable: 

Pairs covered in each test case: 

DU-pair coverage: 

## Range.contains 

Data flow diagram: 

Def-use sets: 

DU-pairs per variable: 

Pairs covered in each test case: 

DU-pair coverage: 

# 3 A detailed description of the testing strategy for the new unit test

Text…

# 4 A high level description of five selected test cases you have designed using coverage information, and how they have increased code coverage

Text…

# 5 A detailed report of the coverage achieved of each class and method (a screen shot from the code cover results in green and red color would suffice)

Text…

# 6 Pros and Cons of coverage tools used and Metrics you report

Text…

# 7 A comparison on the advantages and disadvantages of requirements-based test generation and coverage-based test generation.

Text…

# 8 A discussion on how the team work/effort was divided and managed

Text…

# 9 Any difficulties encountered, challenges overcome, and lessons learned from performing the lab

Text…

# 10 Comments/feedback on the lab itself

Text…
