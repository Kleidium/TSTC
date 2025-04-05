#Program: Numbers.py
#Course: ITSE-1373-7P1
#Author: Kc Poland
#Description: This program accepts 10 odd numbers from the user from 1-99. Then, the largest number, the smallest number, and the average of the numbers are written to a file.



# Variables #
numList = []
numQuantity = 0
numLarge = 0
numSmall = 100
numAverage = 0


# Welcome Message #
print("\nWelcome to Numbot.")
print("We will be entering 10 odd numbers.")


# Program Loop #
while (numQuantity < 10):
    
    number = int(input("\nPlease input an odd number (1-99): "))
    
	# Check Validity
    if (number % 2 == 1 and number < 100 and number > 0):
        numList.append(number)
        numQuantity += 1
        numAverage = numAverage + number
        
        if number > numLarge:
            numLarge = number
        if number < numSmall:
            numSmall = number
        
        print("\nCurrent List: " + str(numList))
    else:
        print("Invalid input. Please enter an odd number from 1-99.")
else:
	# Loop Complete #
	numAverage = numAverage / 10
    
	# Write to File
	file = open("numbers.txt", "w")
	file.write("Largest Number: " + str(numLarge))
	file.write("\nSmallest Number: " + str(numSmall))
	file.write("\nAverage Value of Numbers: " + str(numAverage))
	file.close()
    
	# Results
	print("\n\nThank you. Here are your numbers: " + str(numList))
	print("\n\tLargest Number: " + str(numLarge))
	print("\tSmallest Number: " + str(numSmall))
	print("\tAverage Value of Numbers: " + str(numAverage))
	print("\nThese numbers have been written to your numbers.txt file for convenience.\n")