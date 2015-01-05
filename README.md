File for the code2040 API CHALLENGE
===================================
Author : Itzel Martinez

Instructions on How to Run the Code for Each Stage of the Challenge 
===================================================================

STAGE I: ReverseString
STAGE II: Haystack
STAGE III: Prefix
STAGE IV: DatingGame

Step 1 : Compiling
======

First compile the code by using the following statement for
stages I - III on the command line: 

	javac -cp .:java-json.jar -d . <FileName>.java

Compile the last stage of the challenge and the RunAll file by using the following statement:

	javac -cp .:java-json.jar:joda-time-2.5.jar -d . <FileName>.java 

Note: Can also compile all the files by using the statement for the last stage,


Step 2 : Running Individual Files
======

Run stage I - III individually by using the following statement on the command line:

	java -cp .:java-json.jar challenge.<FileName>

Run the last stage by using the following statement:
 
 	 java -cp .:java-json.jar:joda-time-2.5.jar challenge.<FileName>

Note: Can run all stages using the statement for the last stage.

 
Step 3 : Running All Files
========

Run all the files by using the following statement:

	java -cp .:java-json.jar:joda-time-2.5.jar challenge.RunAll



