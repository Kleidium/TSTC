# Program: StarHighHonorRoll
# Course: ITSE 1302 7P3
# Author: Kc Poland
# Description: This program processes a file containing student information in order to determine which students made the A Honor Roll and which students made the B Honor Roll.
# The total number of students, as well as the number and percentage of A honor roll and B honor roll students, are displayed. A honor roll students are output to the AHonorRoll.dat file, and B honor roll students are output to the BHonorRoll.dat file.
# Both output files are sorted alphabetically.


# Open grades.dat file
grades = open("grades.dat")
print("Processing student grades...")


# Create A honor roll and B honor roll lists
aList = []
bList = []


# Create grand total, A honor total, and B honor total accumulators
gTotal = 0
aTotal = 0
bTotal = 0


# For each line in the file
for line in grades:

    # Split the record by its fields, add to grand total
    tempList = line.split(",")
    gTotal = gTotal + 1

    # Store each field from the record
    name = tempList[0]
    idNum = tempList[1]
    grade = int(tempList[2])

    if grade >= 80:
        if grade > 89:
            # Add to A honor roll
            aList.append(name + "\n")
            aTotal = aTotal + 1
        else:
            # Add to B honor roll
            bList.append(name + "\n")
            bTotal = bTotal + 1


# Close grades.dat file
grades.close()
print("Processing complete.")


# Calculate percentage of A and B honor roll students
aPercent = round(((aTotal/gTotal) * 100), 2)
bPercent = round(((bTotal/gTotal) * 100), 2)


# Display results
print("")
print("SUMMARY STATISTICS")
print("-------------------")
print("Total students: " + str(gTotal))
print("A Honor Roll Students: " + str(aTotal) + " (" + str(aPercent) + "%)")
print("B Honor Roll Students: " + str(bTotal) + " (" + str(bPercent) + "%)")
print("")


# Sort lists alphabetically
aList.sort()
bList.sort()


# Write A honor roll file
aOutput = open("AHonorRoll.dat", "w")
for name in aList:
    aOutput.write(name)

aOutput.close()
print("AHonorRoll.dat file created...")


# Write B honor roll file
bOutput = open("BHonorRoll.dat", "w")
for name in bList:
    bOutput.write(name)

bOutput.close()
print("BHonorRoll.dat file created...")


# The end
print("")
print("End of program.")
print("")