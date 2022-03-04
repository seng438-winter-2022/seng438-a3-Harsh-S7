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

In this lab we are working on coverage-based testing. With the help of a range of tools we are using coverage statistics to determine how much of our code is tested and how much of it requires more testing. By taking note of branch coverage and method coverage, we are checking how much of our code is covered by the test suite that we have developed. Then by using manual calculation of data flow coverage, we are determining how effective coverage tools are. There are instances for example where the statement coverage is 100% but the flaw is not exposed until and unless a data flow graph is drawn which then shows exactly where the issue is. With the use of the coverage tools provided, we then further the test suite development to increase the statement,branch and condition and/or method coverage depending on the tool being used.

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

The unit-test strategy employed for this was white box testing. In White Box testing, the unit tests created were utilizing the source code. In order to ensure the unit tests were providing excellent coverage, we first looked at the if statements and examined all the different directions that code can go depending on the parameters inputted. Through this method we were able to hit a coverage of roughly 80% for instruction coverage. Once the initial unit tests have been written and developed, the team will utilize EclEmma to determine the coverage for instruction, branch and method for the complete unit test package for each class. 
We will then utilize the missing branches column within EclEmma to understand what branches, instructions and/or methods we are missing as each instruction that is missing will be highlighted red by eclipse and then the tester will create a test case to address this inefficiency within the test coverage. This step will be repeated for as long as needed and till the tester reaches the required coverage percentage for each style - 90% for Instruction Counters, 70% for Branch Counters and 60% for Branch Counters.
To sum it up, we will first utilize white box testing methodology to create the initial test cases and then utilize EclEmma to find and improve the coverage.


# 4 A high level description of five selected test cases you have designed using coverage information, and how they have increased code coverage

Data Utilities - testEqual_emptyAndNull():
Description
In the tests for the equal() method. This Method checks if the equal method can properly detect the difference between a null and empty array. This covers 1 if statement that checks if the 2nd array is null.
Before
![image](https://user-images.githubusercontent.com/81480268/156847966-0b4fe5a8-7ea1-4f1d-9db1-e5827cb66da6.png)

After
![image](https://user-images.githubusercontent.com/81480268/156847993-d8a0e33b-63de-4de4-9e28-d3e471c7fe78.png)

Data Utilities - testCalculateColumn_longerArray():
Description
This test is for the 3input overloaded version CalculateColumnTotal(). In this test we try to cover an if statement that checks to see if the column array is longer than the total numbers of columns found in the values2D object. 
Before
![image](https://user-images.githubusercontent.com/81480268/156848044-4e66cb3d-fc17-4dfd-8b73-04d00099240d.png)

After
![image](https://user-images.githubusercontent.com/81480268/156848071-272e0768-aec0-4cc6-b6d7-dd82c8107f9f.png)

Data Utilities - testCalculateRow_longerArray():
Description
This test is for the 3input overloaded version CalculateRowTotal(). In this test we try to cover an if statement that checks to see if the column array is longer than the total numbers of rows found in the values2D object. 
Before
![image](https://user-images.githubusercontent.com/81480268/156848132-70b41aef-f168-472c-b759-ab1e33b45a55.png)

After
![image](https://user-images.githubusercontent.com/81480268/156848159-c0355911-ebd4-4e62-820c-680c71eeca66.png)

Range - testrangeCreationNull()
Description
This test method checks the case for what happens when the range objective that is being created is not allowed and in order to ensure that an exception is thrown this test is being used
Before
![image](https://user-images.githubusercontent.com/81480268/156848234-66c14fc2-19cd-4f32-8e4b-d83049f4c9f6.png)

After
![image](https://user-images.githubusercontent.com/81480268/156848256-caf0f5ce-48ed-44e3-a1f8-7d38bc676de1.png)

Range - testExpandToIncludeSame()
Description
This method checks for the expandToInclude method within the range class. This test method covers for the if statement where the value is greater than the range.getUpperBound().
Before
![image](https://user-images.githubusercontent.com/81480268/156848287-449c21b4-8ce3-4be1-8036-dea1fa0c2885.png)

After
![image](https://user-images.githubusercontent.com/81480268/156848314-37c02ef4-6d50-4b8a-b117-d5e9d8695a26.png)


# 5 A detailed report of the coverage achieved of each class and method (a screen shot from the code cover results in green and red color would suffice)

Coverage Switch
Due to EclEmma not supporting condition coverage, we switched condition coverage for method coverage.
Range - 90% Instruction Counters
![image](https://user-images.githubusercontent.com/81480268/156848562-edc12348-4031-4c47-8d9d-db2c418b56ca.png)

Range - 70% Branch Counters
![image](https://user-images.githubusercontent.com/81480268/156848625-95278322-0c58-43e4-9b05-dd3511db00ba.png)

Range - 60% Method Counters
![image](https://user-images.githubusercontent.com/81480268/156848668-484a151d-324c-4e2f-af48-df2460c4408b.png)

Data Utilities - 90% Instruction Counters
![image](https://user-images.githubusercontent.com/81480268/156848711-78415957-e172-48f4-ab59-ca62020a55db.png)

Data Utilities - 70% Branch Counters
![image](https://user-images.githubusercontent.com/81480268/156848742-37e7bcc1-90a2-4265-8e4a-5b1a7271ef67.png)

Data Utilities - 60% Method Counters
![image](https://user-images.githubusercontent.com/81480268/156848773-2f8fd490-50fe-4199-aae1-3f09ded30f52.png)


# 6 Pros and Cons of coverage tools used and Metrics you report

We used the code coverage tool EclEmma and the other tools we used were not easy to configure. We tried to install all of the tools, CodeCover and Clover were the only ones that were able to install successfully while the other three tools were not installed. Most of the tools in the list except EclEmma and Clover did not have any troubleshooting guides which were helping us out. CodeCover and Clover after installing were not working. With CodeCover the error was “Plug in “org.codecover.eclipse” was unable to instantiate class”. With Clover the issue was that despite it installing, we were unable to extract metrics from it because no matter how many times we configured different properties, it showed the test execution zero times so due to this no metrics were extracted.

Now since we used EclEmma, we will list its pros and cons:
| Pros      |    Cons    |
| -------------- | ---      |
| Allows to track instructions, branches and lines |          |

# 7 A comparison on the advantages and disadvantages of requirements-based test generation and coverage-based test generation.

Text…

# 8 A discussion on how the team work/effort was divided and managed

Text…

# 9 Any difficulties encountered, challenges overcome, and lessons learned from performing the lab

Text…

# 10 Comments/feedback on the lab itself

Text…
