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

## 2.1 DataUtilities.calculateColumnTotal

Data flow diagram: 
![asn2DataUtilitiesDiagram3](https://user-images.githubusercontent.com/81480268/156491407-2afa9345-682c-43e9-8935-5bbf713293eb.jpg)

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
```
data: {(1, 1), (1, 2)}
column: {(1, 2)}
total: {(1, 4), (4, 6)}
rowCount: {(1, 2)}
n: {(2, 4)}
r: {(2, 5)}
```

Pairs covered in each test case: 
```
testCalculateColumnTotal_indexesOutOfOrder: data{(1, 1), (1, 2)}, column: {(1, 2)}, total: {(1, 4), (4, 6)}, rowCount: {(1, 2)}, n: {(2, 4)}, r: {(2, 5)}
testSimple: data{(1, 1), (1, 2)}, column: {(1, 2)}, total: {(1, 4), (4, 6)}, rowCount: {(1, 2)}, n: {(2, 4)}, r: {(2, 5)}
testDecimal: data{(1, 1), (1, 2)}, column: {(1, 2)}, total: {(1, 4), (4, 6)}, rowCount: {(1, 2)}, n: {(2, 4)}, r: {(2, 5)}
testCalculateColumn_longerArray: data{(1, 1), (1, 2)}, column: {(1, 2)}, total: {(1, 4), (4, 6)}, rowCount: {(1, 2)}, n: {(2, 4)}, r: {(2, 5)}
testCalculateColumnTotal_1Index: data{(1, 1), (1, 2)}, column: {(1, 2)}, total: {(1, 4), (4, 6)}, rowCount: {(1, 2)}, n: {(2, 4)}, r: {(2, 5)}
```

DU-pair coverage: 
```
coverage = 8/8 * 100% = 100%
```

## 2.2 Range.contains 

Data flow diagram: 
![asn2Range](https://user-images.githubusercontent.com/81480268/156491943-1f6b0643-e044-47f7-aed5-23a2dcdbd957.jpg)

Def-use sets: 
```
def(1) = {value, upper, lower}
use(1) = {value, upper, lower}
```

DU-pairs per variable: 
```
value: {(1, 1)}
upper: {(1, 1)}
lower: {(1, 1)}
```

Pairs covered in each test case: 
```
containsValueNotInRange: value(1, 1), upper(1, 1), lower(1, 1) 
containsValueInRange: value(1, 1), upper(1, 1), lower(1, 1) 
containsValueUpperBound: value(1, 1), upper(1, 1), lower(1, 1) 
containsValueLowerBound: value(1, 1), upper(1, 1), lower(1, 1) 
```

DU-pair coverage: 
```
3/3 * 100% = 100% 
```

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
