#Program: KcPolandTestAverage
#Course: ITSE 1302 7P3
#Author: Kc Poland
#Description: Calculate the average score amongst four given test scores.


#Variables (Four test Scores)
testNum1 = float(input("Enter 1st Test Score: "))
testNum2 = float(input("Enter 2nd Test Score: "))
testNum3 = float(input("Enter 3rd Test Score: "))
testNum4 = float(input("Enter 4th Test Score: "))

#Calculate and print average score
avgScore = float((testNum1 + testNum2 + testNum3 + testNum4) / 4)
print("")
print("The average score is: " + str(avgScore) + "")
print("")