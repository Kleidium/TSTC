# Program: Patrons
# Course: ITSE 1302 7P3
# Author: Kc Poland
# Description: This program allows the user to enter the count of monthly museum patrons (visitors) for each month of the year. 
# The program then displays the month with the least patrons and the month with the most patrons. The program will also display the average monthly visitors for the year.


# Initialize lists, total, min and max values
months = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"]
counts = []
total = 0
minNum = 999999999999
maxNum = -1
minMonth = -1
maxMonth = -1

# Get patron totals for each month and add to grand total while keeping track of lowest and highest totals
for x in range(0, 12):
    mValue = int(input("Enter number of patrons for " + months[x] + ": "))
    counts.append(mValue)
    total = total + mValue
    if counts[x] > maxNum:
        maxNum = counts[x]
        maxMonth = months[x]
    if counts[x] < minNum:
        minNum = counts[x]
        minMonth = months[x]

# Display results
print("")
print(maxMonth + " had the most patrons.")
print(minMonth + " had the least patrons.")
print("")
print("Average monthly visitors are " + str((total / 12)) + ".")
print("")