# Program: Generations
# Course: ITSE 1302 7P3
# Author: Kc Poland
# Description: This program records a person's age and then assigns them a generational cohort based loosely on the year they were born.


# Capture age input
age = int(input("Enter the person's age: "))

# Check their age against generational ranges
if age < 6:
    print("This person is from Generation Alpha.")
elif (age >= 6 and age <= 24):
    print("This person is from Generation Z.")
elif (age >= 25 and age <= 40):
    print("This person is from the Millennial generation.")
elif (age >= 41 and age <= 56):
    print("This person is from Generation X.")
elif (age >= 57 and age <= 75):
    print("This person is from the Baby Boomer generation.")
elif (age >= 76 and age <= 93):
    print("This person is from the Silent Generation.")
else:
    print("This person is from The Greatest Generation.")